client_java
===========

客户端调用示例 - JAVA

如果使用JAVA语言开发客户端，则可以使用提供的JAVA包，进行快速请求，对上面的示例接口使用如下：

package com.dogstar.shakenext.test;

import com.dogstar.shakenext.apiclient.*;
import com.dogstar.shakenext.apiclient.SN_Response.SN_Response_Status;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SN_ApiClient_Test extends TestCase {
    public void testHelloWorld() {
        SN_ApiClient client = SN_ApiClient.getInstance();
        SN_Params params = SN_Params.newInsance()
                .withHost("http://dogstar.api.shakenext.com")
                .withController("Examples")
                .withAction("getWelcome")
                .set("name", "dogstar");
        SN_Response response = client.request(params);
        
        Assert.assertEquals(SN_Response_Status.OK, response.getStatus());
        Assert.assertEquals("{\"content\":\"Hello Wolrd\",\"name\":\"dogstar\"}", response.getData());
    }
}

一行代码

为了展示JAVA客户端的简单调用，可以用一行代码来做示例：
SN_Response response = SN_ApiClient.getInstance().request(SN_Params.newInsance("http://localhost"));

但实际开发更应该使用更明确的写法，并且配合严格的单元测试，即使这里的一行调用代码很吸引人，但对睦读它的人理想成本很高。更理想的调用应该使用三行代码。

SN_Params params = SN_Params.newInsance("http://localhost/");
SN_ApiClient client = SN_ApiClient.getInstance();
SN_Response response = client.request(params);

很明显，上面的三行代码很好地说明了请求过程：

    构建请求参数

    构建请求实例

    获取接口结果

之所以这样设计，是为了提高客户端开发人员的关注：我只需要关心给什么参数和获取返回结果就可以了，而不需要关心如何去请求。
渐进式的请求参数

为了轻松设置请求参数，以及区分业务参数和系统参数，这里的参数类SN_Params可使用连贯的设置方式。如下示例：

SN_Params params = SN_Params.newInsance();
//业务参数设置
params.set("name", "dogstar").set("year", 2014 + "").set("sex", "male");
//系统参数设置
params.withHost("http://localhost/").withAction("actionName").withController("controllerName");

灵活的扩展

为了方便后期的扩展，和为开发人员提供更大的自由空间，并遵循开放-关闭原则，这里将接口请求的方式以及对接口结果的解析都利用代理模式和工厂模式进行了封装。后期如果需要进行扩展，可以在实现SN_Request或SN_Formatter接口，并对相应的工厂类进行扩展即可以外部调用。

并且当在工厂类里尝试创建一个非法的实例时，将会返回一个None对象，避免外部对null的判断或者对异常的处理。当然，在外部尝试使用这个不存在的实例进行操作时，还会抛出一个异常，以便告知开发人员。
