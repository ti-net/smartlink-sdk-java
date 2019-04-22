## 配置 Idea 环境

SDK 开发使用Setter 模板

在 JOPO 类中 右键 -> Generate -> Setter， 然后添加Template

SDK Request Model 类使用 GET 方法

```
sdk_get_method_set

#set($paramName = $helper.getParamName($field, $project))
#if($field.modifierStatic)
static ##
#end
void set$StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field, $project)))($field.type $paramName) {
#if ($field.name == $paramName)
    #if (!$field.modifierStatic)
    this.##
    #else
        $classname.##
    #end
#end
$field.name = $paramName;
if ($paramName != null) {
    putQueryParameter("$paramName", $paramName);
}
}
```

SDK Request Model 类使用 POST 方法
```
sdk_post_method_set

#set($paramName = $helper.getParamName($field, $project))
#if($field.modifierStatic)
static ##
#end
void set$StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field, $project)))($field.type $paramName) {
#if ($field.name == $paramName)
    #if (!$field.modifierStatic)
    this.##
    #else
        $classname.##
    #end
#end
$field.name = $paramName;
if ($paramName != null) {
putBodyParameter("$paramName", $paramName);
}
}
```

## 示例

每个请求分 Request 和 Response ， 开发人员需要实现 BaseResponse 和 BaseRequest

以创建用户为例：

```java
import HttpMethodType;
import BaseRequest;

public class UserRequset extends BaseRequest<UserResponse> {

    private String name;
    private String password;

    public UserRequset() {
        super("/user/create", HttpMethodType.GET);
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            putQueryParameter("name", name);
        }
    }

    public void setPassword(String password) {
        this.password = password;
        if (password != null) {
            putQueryParameter("password", password);
        }
    }

    @Override
    public Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }
}
```

```java
import BaseResponse;

public class UserResponse extends BaseResponse {

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

```