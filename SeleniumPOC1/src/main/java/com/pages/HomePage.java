package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;


By AppLauncher = By.xpath("//div[@class='slds-icon-waffle']");
By ServiceOption= By.xpath("//p[contains(text(),'Service')]");

By Accounts=By.xpath("//span[@class='slds-truncate'][contains(text(),'Accounts')]");
By NewButton=By.xpath("//div[contains(text(),'New')]");
By AccountName=By.xpath("//body[contains(@class,'desktop')]/div[contains(@class,'desktop container forceStyle oneOne lafStandardLayoutContainer lafAppLayoutHost forceAccess tablet')]/div[contains(@class,'DESKTOP uiContainerManager')]/div[contains(@class,'DESKTOP uiModal--medium uiModal--recordActionWrapper uiModal forceModal open active')]/div[contains(@class,'panel slds-modal slds-fade-in-open')]/div[contains(@class,'modal-container slds-modal__container')]/div[contains(@class,'modal-body scrollable slds-modal__content slds-p-around--medium')]/div[contains(@class,'windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost')]/div[contains(@class,'isModal inlinePanel oneRecordActionWrapper')]/div[contains(@class,'actionBody')]/div[contains(@class,'allow-horizontal-form wide-input-break full-width forceDetailPanelDesktop')]/article/div[contains(@class,'test-id__record-layout-container riseTransitionEnabled')]/div[contains(@class,'full forcePageBlock forceRecordLayout')]/div[contains(@class,'slds-is-open full forcePageBlockSection forcePageBlockSectionEdit')]/div[@class='test-id__section-content slds-section__content section__content']/div[@class='slds-form slds-form_stacked slds-is-editing']/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
By SaveButton=By.xpath("//button[contains(@class,'slds-button slds-button--neutral uiButton--brand uiButton forceActionButton')]//span[contains(@class,'label bBody')][contains(text(),'Save')]");

public HomePage(WebDriver driver1) {
	this.driver=driver1;
	PageFactory.initElements(driver1, this);
}
public void AppLauncherClick() {
	driver.findElement(AppLauncher).click();
}
public void ServiceOptionClick() {
	driver.findElement(ServiceOption).click();
}
public void AccountsClick() {
	//driver.findElement(Accounts).clear();
	WebElement wb=driver.findElement(Accounts);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", wb);
}
public void NewAccountCLick() {
	driver.findElement(NewButton).click();
}
public void EnterAccountName(String accountName) {
	driver.findElement(AccountName).clear();
	driver.findElement(AccountName).sendKeys(accountName);
	driver.findElement(SaveButton).click();
}
}
