package ids;

public class IDs {

    public static class LoginPage {
        public static final String xpath_LOGIN = "//table[@class='login-table']/tbody/tr/td/input[@name='login']";
        public static final String xpath_PASSWD = "//table[@class='login-table']/tbody/tr/td/input[@name='passwd']";
        public static final String xpath_SUBMIT_BTN = "//table[@class='login-table']/tbody/tr/td/button";

    }

    public static class NaviPage {
        public static final String xpath_LPANEL_CREATE_OUT_DOC = "//a[@class='link'][contains(@navigatecontentid,'dc_DC_OUT_dcOutAction.do_491839632_0_0')]";

        public static final String xpath_LEFT_FRAME = "//frameset/frame[@name='left']";
        public static final String xpath_RIGHT_FRAME = "//frameset/frame[@name='right']";

        public static final String xpath_OUTDOC_FORM = "//form[@id='dcOutForm']";


    }

    public static class OutDocForm {
        public static final String xpath_DELIVERY_TYPE_SELECTOR = "//select[@name='deliveryTypeId']";
        public static final String xpath_DELIVERY_SUBTYPE_SELECTOR = "//select[@name='deliveryChildTypeId']";
        public static final String xpath_DELIVERY_DETAILS = "//textarea[@name='doc.receiverInfo']";
        public static final String xpath_TYPE = "//select[@name='doc.customTypeId']";
        public static final String xpath_ADD_CUSTOM_TYPE_BTN = "//a[contains(@onclick,'addCustomType')]";
        public static final String xpath_FROM_INPUT = "//input[@name='organizationFieldFor_selectedSenderOrganizationId']";
        public static final String xpath_DOC_INCOMING = "//input[@name='autoCompleteField']";
        public static final String xpath_FILLCARDBY_OUTDOC_YESBTN = "//div[@class='ui-dialog-buttonset']/button/span[text()='Да']";
        public static final String xpath_FILLCARDBY_OUTDOC_NOBTN = "//div[@class='ui-dialog-buttonset']/button/span[text()='Нет']";
        public static final String xpath_DOC_NAME = "//textarea[@name='doc.name']";
        public static final String xpath_ADD_ORG_BTN = "//div[@id='receiversNode']/span";
        public static final String xpath_ADDORG_NAME_INPUTFIELD = "//input[@id='uniqName_3_0_organizationId']";
        public static final String xpath_ADDORG_SIGNER_INPUTFIELD = "//input[@id='uniqName_3_0_signerId']";
        public static final String xpath_ADDORG_ADDRESS_INPUTFIELD = "//input[@id='uniqName_3_0_addressId']";

        public static final String xpath_WHOSIGNS_INPUT = "//input[@name='managerFio']";
        public static final String xpath_PERFORMER_INPUT = "//input[@name='performerFio']";
        public static final String xpath_WHOSIGNS_HREF = "//input[@name='managerFio']/parent::*/a";
        public static final String xpath_PERFORMER_HREF = "//input[@name='performerFio']/parent::*/a";


        //public static final String xpath_
    }

    public static class UsersSelectPopup {
        public static final String SEARCH_BTN = "//input[@class='btn'][@value='Поиск']";
        public static final String FIO_SEARCH_FIELD = "//input[@name='fio']";

    }

    public static class AfterCreateOutDoc {
        public static final String xpath_OUTDOC_AFTERCREATE_FRAME = "//frame[contains(@src ,'/107140/dc_out_left.jsp')]";
    }


    }
