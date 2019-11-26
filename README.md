#hanfu
### 请求端口

#### 一切请求都是post接口，并且为json数据上传。

#### 登录接口

请求方式：POST

URL： http://localhost/API/login 

请求格式：

```json
{"account":"123456","password":"123456"}
```

------

返回参数

成功参数：

code	状态码 200成功 500失败

sex	性别 1男 2女 3保密

token	令牌

```json
{"code":200,"data":{"account":"123456","name":"暖风","sex":"3","token":"令牌"},"message":"/getMessage"}
```

------

失败参数：

code	状态码 200成功 500失败

data	提示信息

message	无用信息

```
{"code":500,"data":"账户登录失败！","message":"/404"}
```

#### 注册请求

请求方式：POST

URL：  http://localhost/API/register 

请求格式：

```json
{
	"account":"123456",
	"password":"123456",
	"name": "name",
	"sex": "1"
}
```

------

返回参数

成功参数：

```json
{"code":200,"message":"注册成功！"}
```

------

失败参数：

```json
{"code":500,"data":"\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '12345678' for key 'users_account_uindex'\r\n### The error may exist in com/yangjiaying/hanfu/modular/login/dao/loginMapper.java (best guess)\r\n### The error may involve com.yangjiaying.hanfu.modular.login.dao.loginMapper.register-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into users(account,password,name,sex) values(?,?,?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '12345678' for key 'users_account_uindex'\n; Duplicate entry '12345678' for key 'users_account_uindex'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '12345678' for key 'users_account_uindex'","message":"注册失败"}
```

#### 注册时检测账户是否可注册

请求方式：POST

URL：  http://localhost/API/isItRegistered 

json请求格式：

```json
{"account":"1234568"}
```

------

返回参数

成功参数：

```json
{"code":500,"message":"账户1234568可注册！"}
```

------

失败参数：

```json
{"code":200,"message":"账户已存在！"}
```

