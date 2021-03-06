Sirius Java Client Web
======

This is the client for Sirius platform responsible for Web applications interaction. It provides the communication channel to [Sirius Server Web module](https://github.com/mkolisnyk/Sirius/tree/master/Sirius-Server-Web#sirius-server-web-overview) as well as provides high-level API for making  convenient page objects definition and general interaction with web application under test.

# Installation

The Sirius Web client library is delivered in 2 ways:

1. Self-contained Java library provided as **jar** file. It can be taken from [downloads page](http://code.google.com/p/sirius-platform/downloads/list). All we need to do is just unpack the archive and include appropriate **jar** file into the project.

2. Maven dependencies. Each client module is also published to Maven repository. The list of available modules can be found on [the following page](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22sirius.client.web%22). So, if we have Maven project where we'd like to use Sirius Java client libraries we should update Maven script with the entry like this:
``` xml
	<dependency>
		<groupId>com.github.mkolisnyk</groupId>
		<artifactId>sirius.client.web</artifactId>
		<version>LATEST</version>
	</dependency>
```
or any similar for all the modules we'd like to include.

# Usage Sample

After that we can use library classes, e.g:

``` java
	import org.sirius.client.web.classes.Page;
	import org.sirius.client.web.classes.WebButton;
	import org.sirius.client.web.classes.WebEdit;
	...
	
	WebClient client = new WebClient();
```
In this example we've just initialized main entry point for Sirius Win32 API and after that we can make window declarations like:

``` java
	public class GoogleStart extends Page {
		
		public WebEdit edtQuery = null;
		public WebButton btnSearch = null;
		
		public GoogleStart(WebClient client){
			super(client);
			edtQuery = new WebEdit(this,"name=q");
			btnSearch = new WebButton(this,"name=btnG");
		}
	}	
```

and then use them within the test code like:

``` java
	client.start(WebClient.HTMLUNIT);
	GoogleStart main = new GoogleStart(client);
	
	main.open("http://google.com");
	main.edtQuery.type("Hello world!!!");
	main.btnSearch.click();
```

Detailed information about Sirius Web client API usage can be found on the [project wiki page](https://github.com/mkolisnyk/Sirius/wiki/Web-Client:-Web-Interaction) where all major concepts are described.

Documentation
======
[Project Wiki](https://github.com/mkolisnyk/Sirius/wiki)

Releases
======
All available client modules can be found [at the Maven repository](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.github.mkolisnyk%22%20AND%20a%3A%22sirius.client.web%22). 

Blog Links
======
[Related blog entries](http://mkolisnyk.blogspot.com/search/label/Sirius)

Authors
======
Myk Kolisnyk (kolesnik.nickolay@gmail.com)

<a href="http://ua.linkedin.com/pub/mykola-kolisnyk/14/533/903"><img src="http://www.linkedin.com/img/webpromo/btn_profile_bluetxt_80x15.png" width="80" height="15" border="0" alt="View Mykola Kolisnyk's profile on LinkedIn"></a>
<a href="http://plus.google.com/108480514086204589709?prsrc=3" rel="publisher" style="text-decoration:none;">
<img src="http://ssl.gstatic.com/images/icons/gplus-16.png" alt="Google+" style="border:0;width:16px;height:16px;"/></a>
