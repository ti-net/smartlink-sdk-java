# 同步企业账号的oem配置

## 1. 推送企业oem配置

### 1.1 接口说明

推送企业oem配置

###  1.2 SDK对象

PushOemRequest

### 1.3 接口地址


  PSOT: {ip}/auth/pushOem 

### 1.4 接口请求方式

POST

### 1.5 请求参数

| 参数名   		| 类型    | 是否必选 | 描述                          				 |
| -------- 		| ------  | -------- | ----------------------------------------------|
| thumbnailIconName | String  | 是       | 缩略图文件名 |
| thumbnailIconUrl | String          | 是                | 缩略图地址 |
| expandIconName | string | 是       | 展开图文件名	|
| expandIconUrl | string | 是     | 展开图地址	|
| titleIconName | string | 是 | 标题图标文件名	|
| titleIconUrl | string | 是 | 标题图标地址	|
| titleText | string | 是 | 标题文本	|
| oemAccountId | string | 是 | oem cc平台账号id	|
| accountLoginName | string | 是 | 账号登录名	|

## 1. 删除企业oem配置

### 1.1 接口说明

删除企业oem配置

###  1.2 SDK对象

DeleteOemRequest

### 1.3 接口地址


  delete: {ip}/auth/deleteOem 

### 1.4 接口请求方式

delete

### 1.5 请求参数

| 参数名            | 类型   | 是否必选 | 描述             |
| ----------------- | ------ | -------- | ---------------- |
| oemAccountId      | string | 是       | oem cc平台账号id |