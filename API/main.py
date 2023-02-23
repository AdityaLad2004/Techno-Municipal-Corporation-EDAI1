

import pypyodbc as odbc

DRIVER_NAME = 'SQL SERVER'
SERVER_NAME = 'DESKTOP-9M26SR9\SQLEXPRESS2022'
DATABASE_NAME = 'snapsolvelogininfo'

connection_string = f"""
    DRIVER={{{DRIVER_NAME}}};
    SERVER={SERVER_NAME};
    DATABASE={DATABASE_NAME};
    Trust_Connection=;
    """

conn = odbc.connect(connection_string)
#print(conn)

username ='9579318602'
password='Aditya.lad'
sql=f"""select * from dbo.memberslogin where mobno='{username}' and userpassword='{password}'"""
#print(sql)
cursor = conn.cursor()
cursor.execute(sql)

#print(cursor.rowcount)
if (cursor.rowcount!=0):
    print("User Exist")
else:
    print("Not Exist")

#for i in cursor:
 #   print(i)