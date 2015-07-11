//1.- Clic derecho en el proy/propiedades-> Java Build Path/Libraries
//	a.- add Jar-> Navegamos en nuestro proy/web-inf/lib->TODOS
//2.- Clic derecho en "src" new/other->file
	# Conexion a Base de datos
	driver=com.mysql.jdbc.Driver
	url=jdbc:mysql://localhost:3306/bd_cine2
	username=root
	password=mysql
//3.- util/MySqlDBConexion.java
	private static ResourceBundle rb=ResourceBundle.getBundle("conexion");
	static{
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {}
	}	
	public static Connection getConexion(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					rb.getString("url"),
					rb.getString("username"),
					rb.getString("password"));
		} catch (SQLException e) {}
		return conn;
	}
//4.- factory/Factory.java
	public static final int TIPO_MYSQL=1;
	public static final int TIPO_SQLSERVER=2;
	/* 2.1 creamos la interfaz (clic en foco) */
	public abstract CineDAO getCineDAO();
	
	/* 2.2 creamos la interfaz */
	public static Factory getFactory(int tipo){
		switch(tipo){
		case TIPO_MYSQL:
			return new MySqlFactory();
		default:return null;
		}
	}
//4.1.- interfaces/CineDAO.java
	/* venimos del 2.1 */
	/* interfaz solo va la declaracion de metodos */
	public int insertar(Cine obj);
	public List<Cine> consultar(int idciudad,String direccion);
//4.2.- factory/MySqlFactory.java
	/* venimos del 2.2 */
	public CineDAO getCineDAO() {
		/* 2.2.1 creamos el dao */
		return new MySqlClienteDAO();
	}
//4.2.1.- dao/MySqlClienteDAO
	/* venimos del 2.2.1 */
	public int insertar(Cine obj) {
		/* make code 3 */
		int salida =0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=MySqlDBConexion.getConexion();
			String sql="insert into tb_cine "+" values(nul,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,obj.getNombre());
			pstm.setInt(3,obj.getPrime());
			salida=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return salida;
	}
	@Override
	public List<Cine> consultar(int idciudad, String direccion) {
			/* make code 3.1 */
			List<Cine>lista=new ArrayList<Cine>();
			PreparedStatement pstm=null;
			Connection conn=null;
			ResultSet rs=null;
			try{
				conn=MySqlDBConexion.getConexion();
				String sql="Select * from tb_cine where idciudad=? and direccion like ?";
				pstm=conn.prepareStatement(sql);
				pstm.setInt(1,idciudad);
				pstm.setString(2,"%"+ direccion +"%");
				rs=pstm.executeQuery();
				while(rs.next()){
					Cine obj=new Cine();
					obj.setIdcine(rs.getInt("idcine"));
					obj.setDireccion(rs.getString("idcine"));
					lista.add(obj);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pstm!=null)
						pstm.close();
					if(conn!=null)
						conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return lista;
	}
//5.- service/CineService
	/* make code, venimos del 3*/
	Factory factory =Factory.getFactory(Factory.TIPO_MYSQL);
	CineDAO dao= factory.getCineDAO();
	public int insertar(Cine obj){
		return dao.insertar(obj);
	}
	public List<Cine> consultar(int idciudad,String direccion){
		return dao.consultar(idciudad,direccion);
	}
//6.-servlet/ServletCine.java
	/* crear el service */
	CineService service=new CineService();
	protected void service(HttpServletRequest...) throws...{
		String operacion=request.getParameter("operacion");
		if(operacion!=null){
			if(operacion.equals("insertar")){
				/* 3.1 */
				insertar(request,response);
			}
			if(operacion.equals("consultar")){
				/* 3.2 */
				consultar(request,response);
			}
		}
	}
	/* venimos de acà.. 3.1 */
	private void insertar(HttpServletRequest...) {
		/* obtener datos del insertar */
		String nombre=request.getParameter("nombre");
		int prime=Integer.parseInt(request.getParameter("prime"));
		Cine obj=new Cine();
		obj.setNombre(nombre);
		obj.setPrime(prime);
		
		int salida=service.insertar(obj);		
		if(salida>0){
			System.out.println("Se insertò");
		}else{
			System.out.println("No se insertò");
		}
		try{
			request.getRequestDispatcher("/cine.jsp").forward(request, response);
		}catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
	/* venimos de acà.. 3.2 */
	private void consultar(HttpServletRequest...) {
		int idciudad=Integer.parseInt(request.getParameter("idciudad"));
		String direccion=request.getParameter("direccion");		
		List<Cine> lista=service.consultar(idciudad, direccion);		
		request.setAttribute("cines", lista);		
		try{
			request.getRequestDispatcher("/cine.jsp").forward(request, response);
		}catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
//7.- en cine.jsp
	<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
	<display:table name="cines" id="row" requestURI="ServletCine?operacion=consultar" pagesize="3">
		<display:column property="idcine" title="ID"></display:column>
		<display:column property="nombre" title="Nombre"></display:column>
		<display:column property="direccion" title="direccion"></display:column>
	</display:table>


String nom=(String).request.getAttribute("NOM");