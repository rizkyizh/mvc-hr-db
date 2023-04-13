package views;

import controllers.CountryController;
import views.component.CountryComponentViewImpl;

public class CountryView implements IViews{

    CountryController countryController = new CountryController();
    CountryComponentViewImpl countryComponent = new CountryComponentViewImpl();

    @Override
    public void ShowDataList() {
        countryComponent.displayList(countryController.listContries());
    }

    @Override
    public void searchData() {
        try {
            String inputUser = countryComponent.readString("\nSearch data (enter keyword)");
            countryComponent.displayList(countryController.searchNameByCharacter(inputUser));
        } catch (Exception e) {
            countryComponent.displayMessage(e.getMessage());
        }
    }

    @Override
    public void addData() {
        countryComponent.displayMessage("example id: Japan -> JP");
        String newId = countryComponent.readString("new id (required)");
        String newName = countryComponent.readString("new Name");
        String region_id = countryComponent.readString("region id (id already registered)");
        String result = countryController.create(newId.toUpperCase(), newName, region_id);
        countryComponent.displayMessage(result);
        if (result.contains("successfully")) {
            this.ShowDataList();
        }
    }

    @Override
    public void EditData() {
        this.ShowDataList();
        String newId = countryComponent.readString("\nid (required)");
        String newName = countryComponent.readString("Name");
        String newCount = countryComponent.readString("region id");
        String result = countryController.update(newId, newName, newCount);
        countryComponent.displayMessage(result);
    }

    @Override
    public void DeleteData() {
        this.ShowDataList();
        String id = countryComponent.readString("enter id");
        countryComponent.displayMessage(countryController.delete(id));
    }
    
}
