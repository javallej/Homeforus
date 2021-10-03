package main.java.homeforus.gui;

public class RealtorListingsView {

    private CreateListingWindow createListingWindow;

    public RealtorListingsView() {

    }

    public void setCreateListingWindow(CreateListingWindow createListingWindow) {
        this.createListingWindow = createListingWindow;
    }

    public void hideCreateListingsWindow() {
        createListingWindow.setVisible(false);
        createListingWindow = null;
    }

}
