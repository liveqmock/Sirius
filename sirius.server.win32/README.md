# Sirius Server Win32 overview 

Sirius Server Win32 module contains functionality manipulating with Win32 objects. From the server side it's wrapper on Win32 API via [JNA](http://java.jna.net) library.

Consists of classes dedicated to:
* General windows manipulation
* Dialog functionality
* Menu functionality
* Control-specific functionality

# Endpoints

Each of those classes is represented with dedicated endpoint. Currently the following endpoints are included:

| Endpoint                           | Class                                               | Description |
| ---------------------------------- | --------------------------------------------------- | ----------- |
| http://\<base URL\>/win32/utils      | org.sirius.server.win32.Win32Utils                  | Win32 utility functionality usually wrapper on some callback functions which can not be used via service communication |
| http://\<base URL\>/win32/window     | org.sirius.server.win32.classes.Window              | General operations applicable to mupliple window classes |
| http://\<base URL\>/win32/menu       | org.sirius.server.win32.classes.Menu                | Menu-specific operations |
| http://\<base URL\>/win32/dialog     | org.sirius.server.win32.classes.Dialog              | Dialog-specific operations |
| http://\<base URL\>/win32/button     | org.sirius.server.win32.classes.controls.Button     | Operations specific to the **button** window class |
| http://\<base URL\>/win32/comobox    | org.sirius.server.win32.classes.controls.ComboBox   | Combo box specific operations |
| http://\<base URL\>/win32/edit       | org.sirius.server.win32.classes.controls.Edit       | Text field specific operations |
| http://\<base URL\>/win32/listbox    | org.sirius.server.win32.classes.controls.ListBox    | List box specific operations |
| http://\<base URL\>/win32/tabcontrol | org.sirius.server.win32.classes.controls.TabControl | Tab control specific operations |

# Dependencies

This component depends on Win32 Lib service and contains endpoints to interact with Win32 Lib.

# Installation

# Usage

This component contains the server side functionality and it is used to extend existing server side API.

All the methods are designed to be independent and in most cases they use some specific window handle. So, in order to interact with some specific window we should go through the following steps:
* Identify search criteria for the window
* Search for window based on search criteria
* Call some function interacting with the window

## Identify search criteria for the window

Search criteria is identified by **Win32Locator** data type. For Win32 component the following fields are used:
* **Window class** - the name of the registered window class the target window belongs to. **Default valie is:** (.*)
* **Window Caption** - the text within the window (usually it's the window caption). **Default value is:** (.*)
* **Index** - the number identifying the position in the list of available windows when the search criteria matches multiple window objects. **Default value is:** 0
* **Parent handle** - the handle for the parent window object. If defined the further search will be condicted within the child elements. **Default value is:** 0

The below example shows how to initialize search criteria:

```java
Win32Locator locator = new Win32Locator();
locator.setCaption("Common Controls Examples");
```
Here we look for the main window with the **Common Controls Examples** caption. All other fields set into the default values indicating that we are looking for the first window with that caption for any window class and starting from the top level window.

## Search for window based on search criteria

Once we defined search criteria we can use it to get the handle of the window we want to interact with. Main class for locating windows is **Win32Utils**. In most cases we have to look for windows within objects hierarchy. So, we mostly need **searchWindow** method for that. See the example below:
```java
Win32Utils utils = new Win32Utils();
long hwnd = utils.searchWindow(locator);
```

In some cases we have to look for dialog boxes which are not really siblings of the main window but they are kept as the separate structure within the same process. To look for the windows like that we should use **searchSameThreadWindow** method. E.g.:
```java
Win32Locator locator = new Win32Locator();
locator.setWinClass("#32770");
long hwnd = utils.searchSameThreadWindow(hwnd,locator);
```
In this case the search will be performed in the same thread where the **hwnd** is stored.

## Call some function interacting with the window

Once we have the window handle we can call the Server API functions to interact with the window. E.g.:
```java
Window win = new Window();
win.activate(hwnd);
```

# Links  

* [GitHub project](https://github.com/mkolisnyk/Sirius)
* [Dedicated blog entries](http://mkolisnyk.blogspot.com/search/label/Sirius)

#Authors

Myk Kolisnyk (kolesnik.nickolay@gmail.com) 

<a href="http://ua.linkedin.com/pub/mykola-kolisnyk/14/533/903"><img src="http://www.linkedin.com/img/webpromo/btn_profile_bluetxt_80x15.png" width="80" height="15" border="0" alt="View Mykola Kolisnyk's profile on LinkedIn"></a>
<a href="http://plus.google.com/108480514086204589709?prsrc=3" rel="publisher" style="text-decoration:none;">
<img src="http://ssl.gstatic.com/images/icons/gplus-16.png" alt="Google+" style="border:0;width:16px;height:16px;"/></a>
