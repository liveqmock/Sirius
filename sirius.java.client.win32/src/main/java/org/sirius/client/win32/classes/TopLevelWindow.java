/**
 * .
 */
package org.sirius.client.win32.classes;

import org.sirius.client.win32.Win32Client;
import org.sirius.client.win32.types.Win32Locator;

/**
 * @author Myk Kolisnyk
 * .
 */
public class TopLevelWindow extends MovableWindow {

    /**
     * @param clientValue .
     * @param locatorValue .
     * @throws Exception 
     */
    public TopLevelWindow(
            final Win32Client clientValue,
            final Win32Locator locatorValue) {
        super(clientValue, locatorValue);
    }

    /**
     * .
     * @param clientValue .
     * @param parentValue .
     * @param locatorValue .
     * @throws Exception 
     */
    public TopLevelWindow(
            final Win32Client clientValue,
            final Window parentValue,
            final Win32Locator locatorValue) {
        super(clientValue, parentValue, locatorValue);
    }

    /**
     * .
     * @return .
     * @throws Exception .
     */
    public final Menu menu() throws Exception {
        if (this.exists()) {
            Menu menu = new Menu(getClient(), this);
            return menu;
        }
        return null;
    }

    /**
     * .
     * @throws Exception .
     */
    public final void setActive() throws Exception {
        getClient()
        .core()
        .window()
        .activate(
                getLocator()
                .getHwnd()
                );
    }

    /**
     * .
     * @return .
     * @throws Exception .
     */
    public final Menu systemMenu() throws Exception {
        if (this.exists()) {
            long hmenu = getClient()
                    .core()
                    .window()
                    .getSystemMenu(this.getHwnd(), true);
            Menu menu = new Menu(
                    getClient(),
                    this,
                    hmenu);
            return menu;
        }
        return null;
    }
}
