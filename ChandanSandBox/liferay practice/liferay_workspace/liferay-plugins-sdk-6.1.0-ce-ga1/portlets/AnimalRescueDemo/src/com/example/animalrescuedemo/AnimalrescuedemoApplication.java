package com.example.animalrescuedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.example.animalrescuedemo.model.AnimalBean;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.gwt.server.PortletApplicationContext.PortletListener;
import com.vaadin.terminal.gwt.server.PortletRequestListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AnimalrescuedemoApplication extends Application implements
		SelectedTabChangeListener, ClickListener, PortletListener,
		PortletRequestListener {

	private PortletRequest request;
	private PortletResponse response;
	private ThemeDisplay themeDisplay;
	private Window mainWindow;
	private TabSheet t;
	private Table table = new Table("Search Result");
	private List<AnimalBean> animalList = new ArrayList<AnimalBean>();
	private Button backButton = new Button("Back");
	private Window subwindow;
	private Label description = new Label("");
	private Label content;

	@Override
	public void init() {
		addComponents();
	}

	public void addComponents() {
		mainWindow = new Window("Hellovaadintest Application");
		populateAnimalList();
		table.addContainerProperty("State", String.class, null);
		table.addContainerProperty("Name", PopupView.class, null);
		table.addContainerProperty("Location", String.class, null);
		table.addContainerProperty("Vote", Button.class, null);
		table.setSelectable(true);
		// table.setMultiSelect(true);
		table.setImmediate(true);

		table.addListener(new Table.ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				Object value = event.getProperty().getValue();
				if (null == value) {
					description.setValue("No Description");
				} else {
					description.setValue("Description : " + value);
				}
			}
		});

		for (AnimalBean animal : animalList) {
			Button voteButton = new Button("Vote");
			voteButton.addListener(this);
			voteButton.setData(animal.getName());
			Label content = new Label(animal.getDescription());
			content.setWidth("300px");
			content.setHeight("80px");

			PopupView popup = new PopupView(animal.getName(), content);
			popup.setHideOnMouseOut(false);

			table.addItem(
					new Object[] { animal.getState(), popup,
							animal.getLocation(), voteButton },
					animal.getDescription());
		}

		table.setWidth("90%");
		table.setHeight("250px");

		mainWindow.addComponent(table);
		mainWindow.addComponent(description);
		setMainWindow(mainWindow);
		backButton.addListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				mainWindow.removeAllComponents();
				mainWindow.addComponent(table);
				mainWindow.addComponent(description);
				mainWindow.requestRepaintAll();
			}
		});

	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		TabSheet tabsheet = event.getTabSheet();
		Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
		if (tab != null) {
			getMainWindow().showNotification(
					"Selected tab: " + tab.getCaption());
		}
	}

	@Override
	public void buttonClick(Button.ClickEvent event) {
		System.out.println("Got inside click");
		themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		if (themeDisplay.isSignedIn()) {
			Button voteButton = event.getButton();
			voteButton.setCaption("Thanks for vote");
			voteButton.setEnabled(false);
			String msgString = "Thanks " + user.getFullName()
					+ " for Voting for Shelter:"
					+ (String) voteButton.getData();
			openNotificationWindow(msgString);
			getMainWindow().removeAllComponents();
			Label message = new Label("<h1>Thanks " + user.getFullName()
					+ " for Voting  for Shelter:"
					+ (String) voteButton.getData() + "</h1>");
			message.setContentMode(Label.CONTENT_XHTML);
			getMainWindow().addComponent(message);
			getMainWindow().addComponent(backButton);

		} else {
			openNotificationWindow("Your are not logged in!");
		}
	}

	@Override
	public void handleRenderRequest(RenderRequest request,
			RenderResponse response) {
	}

	@Override
	public void handleActionRequest(ActionRequest request,
			ActionResponse response) {
		System.out.println();
		this.response = response;
	}

	@Override
	public void onRequestStart(PortletRequest request, PortletResponse response) {
		this.request = request;
		this.response = response;

	}

	@Override
	public void onRequestEnd(PortletRequest request, PortletResponse response) {

	}

	private void populateAnimalList() {
		animalList.add(new AnimalBean("AK", "Friends of Pets", "AK",
				"Anchorage", "Friends of Pets description"));
		animalList.add(new AnimalBean("AL", "Prattville/Autauga Human Society",
				"AL", "Prattville",
				"Prattville/Autauga Human Society description"));
		animalList.add(new AnimalBean("AR", "Wynne Friends of Animals", "AR",
				"Wynne", "Wynne Friends of Animals description"));
		animalList.add(new AnimalBean("AZ",
				"Humane Society of Southern Arizona", "AZ", "Tucson",
				"Humane Society of Southern Arizona description"));
		animalList.add(new AnimalBean("CA", "Medfly Brigade Basenji Rescue",
				"CA", "Acton", "Medfly Brigade Basenji Rescue description"));
		animalList.add(new AnimalBean("KO", "Kolkata Friends of Animals", "KO",
				"Kolkata", "Kolkata Friends of Animals description"));
		animalList.add(new AnimalBean("BG",
				"Humane Society of Southern Bangalore", "BG", "Bangalore",
				"Humane Society of Southern Bangalore description"));
		animalList.add(new AnimalBean("DL", "Delhi Brigade Basenji Rescue",
				"DL", "Delhi", "Delhi Brigade Basenji Rescue description"));
	}

	private void openNotificationWindow(String msgString) {
		subwindow = new Window("Voting Notification");
		subwindow.setModal(true);
		subwindow.setHeight("50px");
		subwindow.setWidth("300px");

		VerticalLayout layout = (VerticalLayout) subwindow.getContent();
		layout.setMargin(true);
		layout.setSpacing(true);

		Label message = new Label(msgString);
		message.setContentMode(Label.CONTENT_XHTML);
		subwindow.addComponent(message);

		Button close = new Button("Close", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				(subwindow.getParent()).removeWindow(subwindow);
			}
		});
		layout.addComponent(close);
		layout.setComponentAlignment(close, Alignment.TOP_RIGHT);
		mainWindow.addWindow(subwindow);

	}

}
