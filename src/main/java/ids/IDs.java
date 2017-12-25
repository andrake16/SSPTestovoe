package ids;

public class IDs {

    public static class LoginPage {
        public static final String xpath_LOGIN = "//table[@class='login-table']/tbody/tr/td/input[@name='login']";
        public static final String xpath_PASSWD = "//table[@class='login-table']/tbody/tr/td/input[@name='passwd']";
        public static final String xpath_SUBMIT_BTN = "//table[@class='login-table']/tbody/tr/td/button";

    }

    public static class NaviPage {
        public static final String xpath_LPANEL_CREATE_OUT_DOC = "//a[@class='link'][contains(@navigatecontentid,'dc_DC_OUT_dcOutAction.do_491839632_0_0')]";
    }

}
