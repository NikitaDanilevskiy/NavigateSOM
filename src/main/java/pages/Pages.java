package pages;


import pages.newSOM.*;
import pages.newSOMAdmin.NewSOMAdminGlobalPage;
import pages.newSOMAdmin.NewSOMAdminLoginPage;
import pages.newSOMAdmin.NewSOMAdminRequestDeleterPage;
import pages.newSOMAdmin.NewSOMAdminTenantsPage;
import pages.oldSOM.*;
import utils.AllureLogger;

public class Pages extends AllureLogger {

    //Prod environment
    private static OldSOMCustomerPage oldSomCustomerPage;
    private static OldSOMCustomersPage oldSomCustomersPage;
    private static OldSOMDashboardPage oldSomDashboardPage;
    private static OldSOMGlobalPage oldSomGlobalPage;
    private static OldSOMLoginPage oldSomLoginPage;
    private static OldSOMOrdersPage oldSomOrdersPage;
    private static OldSOMSettingsPage oldSomSettingsPage;
    private static OldSOMUploadsPage oldSomUploadsPage;

    //Demo environment

    private static NewSOMLoginPage newSomLoginPage;
    private static NewSOMGlobalPage newSomGlobalPage;
    private static NewSOMUploadsPage newSomUploadsPage;
    private static NewSOMOrdersPage newSomOrdersPage;
    private static NewSOMOrderPage newSomOrderPage;
    private static NewSOMDashboardPage newSomDashboardPage;
    private static NewSOMRequestDeleterPage newSomRequestDeleterPage;

    //Demo com.navigatesom.nonbdd.admin environment

    private static NewSOMAdminLoginPage newSomAdminLoginPage;
    private static NewSOMAdminRequestDeleterPage newSomAdminRequestDeleterPage;
    private static NewSOMAdminGlobalPage newSomAdminGlobalPage;
    private static NewSOMAdminTenantsPage newSomAdminTenantsPage;






    public static OldSOMCustomerPage somCustomerPage() {
        if (oldSomCustomerPage == null) {
            oldSomCustomerPage = new OldSOMCustomerPage();
        }
        return oldSomCustomerPage;
    }

    public static OldSOMCustomersPage somCustomersPage() {
        if (oldSomCustomersPage == null) {
            oldSomCustomersPage = new OldSOMCustomersPage();
        }
        return oldSomCustomersPage;
    }

    public static OldSOMDashboardPage somDashboardPage() {
        if (oldSomDashboardPage == null) {
            oldSomDashboardPage = new OldSOMDashboardPage();
        }
        return oldSomDashboardPage;
    }

    public static OldSOMGlobalPage somGlobalPage() {
        if (oldSomGlobalPage == null) {
            oldSomGlobalPage = new OldSOMGlobalPage();
        }
        return oldSomGlobalPage;
    }

    public static OldSOMLoginPage somLoginPage() {
        if (oldSomLoginPage == null) {
            oldSomLoginPage = new OldSOMLoginPage();
        }
        return oldSomLoginPage;
    }

    public static OldSOMOrdersPage somOrdersPage() {
        if (oldSomOrdersPage == null) {
            oldSomOrdersPage = new OldSOMOrdersPage();
        }
        return oldSomOrdersPage;
    }

    public static OldSOMSettingsPage somSettingsPage() {
        if (oldSomSettingsPage == null) {
            oldSomSettingsPage = new OldSOMSettingsPage();
        }
        return oldSomSettingsPage;
    }

    public static OldSOMUploadsPage somUploadsPage() {
        if (oldSomUploadsPage == null) {
            oldSomUploadsPage = new OldSOMUploadsPage();
        }
        return oldSomUploadsPage;
    }

    //Demo environment

    public static NewSOMLoginPage newSomLoginPage() {
        if (newSomLoginPage == null) {
            newSomLoginPage = new NewSOMLoginPage();
        }
        return newSomLoginPage;
    }

    public static NewSOMGlobalPage newSomGlobalPage() {
        if (newSomGlobalPage == null) {
            newSomGlobalPage = new NewSOMGlobalPage();
        }
        return newSomGlobalPage;
    }

    public static NewSOMUploadsPage newSomUploadsPage() {
        if (newSomUploadsPage == null) {
            newSomUploadsPage = new NewSOMUploadsPage();
        }
        return newSomUploadsPage;
    }

    public static NewSOMOrdersPage newSomOrdersPage() {
        if (newSomOrdersPage == null) {
            newSomOrdersPage = new NewSOMOrdersPage();
        }
        return newSomOrdersPage;
    }

    public static NewSOMOrderPage newSomOrderPage() {
        if (newSomOrderPage == null) {
            newSomOrderPage = new NewSOMOrderPage();
        }
        return newSomOrderPage;
    }

    public static NewSOMDashboardPage newSomDashboardPage() {
        if (newSomDashboardPage == null) {
            newSomDashboardPage = new NewSOMDashboardPage();
        }
        return newSomDashboardPage;
    }

    public static NewSOMRequestDeleterPage newSomRequestDeleterPage() {
        if (newSomRequestDeleterPage == null) {
            newSomRequestDeleterPage = new NewSOMRequestDeleterPage();
        }
        return newSomRequestDeleterPage;
    }

    //Demo com.navigatesom.nonbdd.admin environment

    public static NewSOMAdminLoginPage newSomAdminLoginPage() {
        if (newSomAdminLoginPage == null) {
            newSomAdminLoginPage = new NewSOMAdminLoginPage();
        }
        return newSomAdminLoginPage;
    }

    public static NewSOMAdminRequestDeleterPage newSomAdminRequestDeleterPage() {
        if (newSomAdminRequestDeleterPage == null) {
            newSomAdminRequestDeleterPage = new NewSOMAdminRequestDeleterPage();
        }
        return newSomAdminRequestDeleterPage;
    }

    public static NewSOMAdminGlobalPage newSomAdminGlobalPage() {
        if (newSomAdminGlobalPage == null) {
            newSomAdminGlobalPage = new NewSOMAdminGlobalPage();
        }
        return newSomAdminGlobalPage;
    }

    public static NewSOMAdminTenantsPage newSomAdminTenantsPage() {
        if (newSomAdminTenantsPage == null) {
            newSomAdminTenantsPage = new NewSOMAdminTenantsPage();
        }
        return newSomAdminTenantsPage;
    }

}
