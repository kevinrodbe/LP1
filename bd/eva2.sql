/* C 
Inserte  registros a la tabla TB_CURSO  desde el archivo plano  (CURSOS.TXT) */
bulk insert tb_curso
from 'C:\CURSOS.txt'
with (fieldterminator = ',', rowterminator = '\n')
go
	
/* C */
update tb_personal set
	fecha_ingreso = GETDATE()
	where ( YEAR(GETDATE()) - year(fecha_ingreso) )>4
/* D */
select * from tb_alumno  a
where (select count(m.idmatricula) 
	from tb_alumno a 
	inner join tb_matricula m
	on a.idalumno=m.idalumno
	group by a.idalumno) > 1

/* Pregunta Nro 4 */
select concat(a.nombre, a.apellidos) as 'Nombres',
	m.fecha, m.idmatricula, sum(c.costo) as 'Costo total'
from tb_alumno a inner join tb_matricula m 
on a.idalumno=m.idalumno inner join tb_curso c on m.idcurso=c.idcurso
group by cube(a.nombre, a.apellidos,m.idmatricula , m.fecha,a.idalumno)

