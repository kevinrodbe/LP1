ALTER DATABASE [Negocios2014] SET RECOVERY SIMPLE
GO
USE [master]
GO
ALTER DATABASE [Negocios2014] SET RECOVERY FULL 
GO
USE [master]
GO
ALTER DATABASE [Negocios2014] SET RECOVERY BULK_LOGGED 
GO
---Backup Completo
Backup DataBase [Negocios2014]
To Disk='C:\BK\Negocios.BAK'
go

Use Negocios2014
go
Select * into TBPersonal
from [RRHH].[empleados]
go
-----------------------
Use master
go
Backup Database [Negocios2014]
to disk='C:\BK\NegociosDiff01.bak'
with Differential
go

Use [Negocios2014]
go
Select * into TBConsumers
From [Ventas].[clientes]
go
-----------------------
Backup DataBase [Negocios2014]
to disk='C:\BK\NegociosFullComprimido.Bak'
With Compression
go
------
USE [master]
RESTORE DATABASE [Negocios2014_test] 
FROM  DISK = 'C:\BK\Negocios.BAK' 
WITH File=1, Nounload, Recovery, restricted_user
GO
------
USE [master]
RESTORE DATABASE [Negocios2014_test] 
FROM  DISK = N'C:\BK\Negocios.BAK' 
WITH FILE = 1,  MOVE N'Negocios2014' TO N'C:\BK\Negocios2014.mdf',  
                MOVE N'Negocios2014_log' TO N'C:\BK\Negocios2014_log.ldf',  
				NOUNLOAD,  STATS = 5, Recovery, Restricted_User
GO
------
USE [master]
RESTORE DATABASE [Negocios2014_Prueba] 
FROM  DISK = N'C:\BK\Negocios.BAK' 
WITH  FILE = 1,  
MOVE N'Negocios2014' TO N'C:\Nueva carpeta\Negocios2014.mdf',  
MOVE N'Negocios2014_log' TO N'C:\Nueva carpeta\Negocios2014_log.ldf',  
NOUNLOAD,  STATS = 5, Recovery, Restricted_User
GO
------
Use master
go
Restore Database [Negocios2014]
From Disk= 'C:\BK\Negocios.BAK' 
With Recovery, Replace
go
------
Restore Database [Negocios2014]
From Disk= 'C:\BK\Negocios.BAK' 
With NoRecovery
go
---------Creando dispositivos de Backup------
USE [master]
GO
EXEC master.dbo.sp_addumpdevice  @devtype = N'disk', 
@logicalname = N'DeviceCopiaFULLNegocios2014', 
@physicalname = N'C:\BK\BKNegociosFull.Bak'
GO
--------------Usando el dispositivo de Backup---------------------------
Backup Database [Negocios2014]
to [DeviceCopiaFULLNegocios2014]
go
------Disenhando el JOB
--Paso 01
Use Master;
DBCC CheckDB(Negocios2014);

--Paso 02
Use Master;
Backup Database [Negocios2014]
to [DeviceCopiaFULLNegocios2014];