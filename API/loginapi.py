from flask import *

import json

from pypyodbc import odbc

app=Flask(__name__)

DRIVER_NAME = 'SQL SERVER'
SERVER_NAME = 'DESKTOP-9M26SR9\SQLEXPRESS2022'
DATABASE_NAME = 'snapsolvelogininfo'

@app.route('/',methods=['GET'])
def home_page():
    data_set={'FirstName':'Aditya', 'LastName':'Lad', 'MobileNumber':'9579318602', 'Password':'Aditya.lad' }
    json_dump=json.dumps(data_set)
    return json_dump

@app.route('/user/',methods=['GET'])
def request_page():

    user_query=str(request.args.get('user'))
    data_set = {'FirstName': 'Aditya', 'LastName': 'Lad', 'MobileNumber': '9579318602',
                'Password': 'Aditya.lad'}
    json_dump=json.dumps(data_set)
    return json_dump


@app.route('/login/',methods=['GET'])
def request_login():
    user_mobile = str(request.args.get('mobile'))
    user_pwd = str(request.args.get('pwd'))
    user_fname = str(request.args.get('fname'))
    user_lname = str(request.args.get('lname'))



    data_set = {'Result': 'true'}
    json_dump=json.dumps(data_set)
    return json_dump


if __name__=='__main__':
    app.run(port=7777)
