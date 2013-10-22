/**
 * 
 */
package org.sirius.server.win32.classes.controls;

import java.rmi.RemoteException;

import org.sirius.server.win32lib.controls.Win32LibControlsClient;
import org.sirius.server.win32lib.controls.scrollbar.IScrollBarContractProxy;

/**
 * @author Myk Kolisnyk
 * 
 */
public class ScrollBar {

    private final Win32LibControlsClient win32lib;
    
    /**
     * 
     */
    public ScrollBar() {
        win32lib = new Win32LibControlsClient();
    }

    /**
     * @param hwnd
     * @return
     * @throws RemoteException
     * @see org.sirius.server.win32lib.controls.scrollbar.IScrollBarContractProxy#getLowerBound(java.lang.Integer)
     */
    public Double getLowerBound(Integer hwnd) throws RemoteException {
        return win32lib.scrollBar().getLowerBound(hwnd);
    }

    /**
     * @param hwnd
     * @return
     * @throws RemoteException
     * @see org.sirius.server.win32lib.controls.scrollbar.IScrollBarContractProxy#getPosition(java.lang.Integer)
     */
    public Double getPosition(Integer hwnd) throws RemoteException {
        return win32lib.scrollBar().getPosition(hwnd);
    }

    /**
     * @param hwnd
     * @return
     * @throws RemoteException
     * @see org.sirius.server.win32lib.controls.scrollbar.IScrollBarContractProxy#getUpperBound(java.lang.Integer)
     */
    public Double getUpperBound(Integer hwnd) throws RemoteException {
        return win32lib.scrollBar().getUpperBound(hwnd);
    }

    /**
     * @param hwnd
     * @param pos
     * @throws RemoteException
     * @see org.sirius.server.win32lib.controls.scrollbar.IScrollBarContractProxy#setPosition(java.lang.Integer,
     *      java.lang.Double)
     */
    public void setPosition(Integer hwnd, Double pos) throws RemoteException {
        win32lib.scrollBar().setPosition(hwnd, pos);
    }
}
