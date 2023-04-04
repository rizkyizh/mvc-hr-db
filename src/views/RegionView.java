package views;

import controllers.RegionController;
import views.component.RegionComponentViewImpl;

public class RegionView implements IViews{

    RegionController regionController = new RegionController();
    RegionComponentViewImpl regionComponent = new RegionComponentViewImpl();

    @Override
    public void ShowDataList() {
        regionComponent.displayList(regionController.listRegions());
    }

    @Override
    public void searchData() {
        try {
            String inputUser = regionComponent.readString("\nSearch data (enter keyword)");
            regionComponent.displayList(regionController.searchNameByCharacter(inputUser));
        } catch (Exception e) {
            regionComponent.displayMessage(e.getMessage());
        }
    }

    @Override
    public void addData() {
        String newId = regionComponent.readString("\nnew id (required)");
        String newName = regionComponent.readString("new Name");
        String newCount = regionComponent.readString("new count");

        String result = regionController.create(newId, newName, newCount);
        regionComponent.displayMessage(result);
        if (result.contains("successfully")) {
            this.ShowDataList();
        }
    }

    @Override
    public void EditData() {
        this.ShowDataList();
        String newId = regionComponent.readString("\nid (required)");
        String newName = regionComponent.readString("Name");
        String newCount = regionComponent.readString("count");

        String result = regionController.update(newId, newName, newCount);
        regionComponent.displayMessage(result);
    
    }

    @Override
    public void DeleteData() {
        this.ShowDataList();
        String id = regionComponent.readString("enter id");
        regionComponent.displayMessage(regionController.delete(id));
        
    }
    
}
