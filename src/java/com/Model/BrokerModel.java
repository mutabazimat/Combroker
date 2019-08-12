package com.Model;

import com.Dao.AdministratorDao;
import com.Dao.BusinessDao;
import com.Dao.CellDao;
import com.Dao.DistrictDao;
import com.Dao.LoginDao;
import com.Dao.ProductDao;
import com.Dao.ProvinceDao;
import com.Dao.RetailerDao;
import com.Dao.SectorDao;
import com.Dao.UserDao;
import com.Dao.WholesalerDao;
import com.Domain.Administrator;
import com.Domain.Business;
import com.Domain.Cell;
import com.Domain.District;
import com.Domain.Product;
import com.Domain.Province;
import com.Domain.Retailer;
import com.Domain.Sector;
import com.Domain.User;
import com.Domain.UserRoles;
import com.Domain.Wholesaler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Matthew
 */
@ManagedBean(name = "Broker")
@SessionScoped
public class BrokerModel {

    private Province province;
    private District district;
    private Sector sector;
    private Cell cell;
    private Product product;
    private User user;
    private Wholesaler wholesaler;
    private Retailer retailer;
    private Business business;
    private Administrator administrator;
    private List<Administrator> administrators;
    private List<User> users;
    private List<Retailer> retailers;
    private List<Wholesaler> wholesalers;
    private List<Business> businesses;
    private List<Product> products;
    private List<Province> provinces;
    private List<District> districts;
    private List<Sector> sectors;
    private List<Cell> cells;
    private String entered;
    private String title;
    private String password, email, firstName;
    private String username;
    private int selectedProvince, selectedDistrict, selectedSector, selectedCell;
    private Date now, dateOfBirth;

    @PostConstruct
    public void init() {
        province = new Province();
        district = new District();
        sector = new Sector();
        cell = new Cell();
        user = new User();
        business = new Business();
        product = new Product();
        retailer = new Retailer();
        wholesaler = new Wholesaler();
        users = new UserDao().getUsers();
        administrator = new Administrator();
        retailers = new RetailerDao().getAllRetailers();
        administrators = new AdministratorDao().getAdministrators();
        wholesalers = new WholesalerDao().getAllWholesalers();
        businesses = new BusinessDao().getAllBusinesses();
        products = new ProductDao().getAllProducts();
        provinces = new ProvinceDao().getProvinces();
        districts = new DistrictDao().getAllDistricts();
        sectors = new SectorDao().getAllSectors();
        cells = new CellDao().getAllCells();

        title = new String();
        password = new String();
        username = new String();
        now = new Date();
    }

    public String login() {
        try {
            User us = new UserDao().findStaffbyUsername(username);
            if (us != null) {
                user = us;

                if (us.getPassword().matches(password)) {
                    title = "title selected";
                    if (us.getUserRoles().toString().matches("ADMIN")) {
                        System.out.println("\n");
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> LOGIN PROCESS.>>>>>>>\n   EMAIL:" + username + ", USERROLE:" + user.getUserRoles() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        return "adminDashboard.xhtml?faces-redirect=true";
                    } else if (us.getUserRoles().toString().matches("WHOLESALER")) {
//                        System.out.println("\n");
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> LOGIN PROCESS.>>>>>>>\n   EMAIL:" + username + ", USERROLE:" + user.getUserRoles() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

//                        allEvents = new ArrayList<>();
//                        for (Event e : new EventDao().getAllEvents()) {
//                            if (user.getUserId() == e.getUser().getUserId()) {
//                                if (!allEvents.contains(e)) {
//                                    allEvents.add(e);
//                                }
//                            }
//                        }
//                        allOwnEvents = allEvents;
                        return "wholeSalerDashboard.xhtml?faces-redirect=true";
                    } else {
                        System.out.println("\n");
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> LOGIN PROCESS.>>>>>>>\n   EMAIL:" + username + ", USERROLE:" + user.getUserRoles() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        return "retailerDashboard.xhtml?faces-redirect=true";
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password is Invalid!", ""));
                    return "login.xhtml?faces-redirect=true";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password is Invalid!", ""));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);

                return "login.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            System.out.println(">>>" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password is Invalid!", ""));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
            return "login.xhtml";
        }
    }

    public void check() {
        try {
            if (title.startsWith("no")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
        }
    }

    public void logout() {
        try {
            title = "no";
            user = new User();
//            user1 = new User();
//            application1 = new Application();
            username = new String();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (Exception e) {
        }
    }

    public void invalidUser() {
        if (title.startsWith("noUser")) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BrokerModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String selectBusiness(Business business) {
        this.business = business;
        return "adminNewBusinessOwner";
    }
    
    public String selectWholeSaler(Wholesaler wholesaler) {
        this.wholesaler = wholesaler;
        return "adminNewBusiness";
    }

//    public String viewBusinessOwner(Business business) {
//        users = new UserDao().getUsers(business.getName());
//        return "adminviewmembers";
//    }
    
//    <<<<<<<<<<<<<<<<<<<<<<<<<<<<     RECORDING LOCATIONS PROCESS BEGINS HERE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
    public void filterDistricts() {
        try {
            districts = new DistrictDao().findAllDistrictByProvince(selectedProvince);
        } catch (Exception e) {
        }
    }

    public void filterSectors() {
        try {
            sectors = new SectorDao().AllSectorByDistrict(selectedDistrict);
        } catch (Exception e) {
        }
    }

    public void filterCells() {
        try {
            cells = new CellDao().AllCellsBySector(selectedSector);
        } catch (Exception e) {
        }
    }

    public void saveProvince() {
        try {
            province.setName(entered);
            new ProvinceDao().create(province);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, province.getName() + " Provicne successfully saved", ""));
            this.province = new Province();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", e.getMessage()));
            e.printStackTrace();
        }
    }

    public void saveDistrict() {
        try {
            district.setName(entered);
            new DistrictDao().create(district);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, province.getName() + " District successfully saved", ""));
            this.district = new District();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", e.getMessage()));
            e.printStackTrace();
        }
    }

    public void saveSector() {
        try {
            sector.setName(entered);
            new SectorDao().create(sector);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, province.getName() + " Sector successfully saved", ""));
            this.sector = new Sector();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", e.getMessage()));
            e.printStackTrace();
        }
    }

    public void saveCell() {
        try {
            cell.setName(entered);
            new CellDao().create(cell);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, province.getName() + " Cell successfully saved", ""));
            this.cell = new Cell();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", e.getMessage()));
            e.printStackTrace();
        }
    }

//    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     MAIN FUNTIONS  BEGINS HERE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
    public void newBusiness() {
        try {
            business.setRegisteredDate(now);
            business.setStatus(true);
            business.setStartDate(business.getStartDate());
            businesses = new BusinessDao().getAllBusinesses();
            business.setUser(new User(user.getUserId()));
//            business.setWholesaler(new Wholesaler(wholesaler.getId()));
            new BusinessDao().create(business);
            businesses = new BusinessDao().getAllBusinesses();
            System.out.println(">>>>>>>>>>>>>>>>Business registered successfully    " + business.getName() + "     >>>>>>>>");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Business successful created !", ""));
            business = new Business();

        } catch (Exception e) {
            
        }
    }

    public void newProduct() {
        try {
            product.setManufactureDate(product.getManufactureDate());
            product.setExpireDate(product.getExpireDate());
            products = new ProductDao().getAllProducts();
            product.setUser(new User(user.getUserId()));
            new ProductDao().create(product);
            products = new ProductDao().getAllProducts();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Product successful created !", ""));
            product = new Product();

        } catch (Exception e) {
        }
    }

//    <<<<<<<<<<<<<<<<<<<<<<<<<<<<     RECORDING USERS PROCESS BEGINS HERE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void newWholesaler() {
        try {
            wholesaler.setDateOfBirth(new java.sql.Date(dateOfBirth.getTime()));
            wholesaler.setUserRoles(UserRoles.WHOLESALER);
            wholesaler.setEmail(email);
            wholesaler.setPassword(password);
            wholesaler.setFirstName(firstName);
            cell = new CellDao().getOnecell(selectedCell);
            if (cell != null) {
                wholesaler.setCell(cell);
                new WholesalerDao().create(wholesaler);
                wholesalers = new WholesalerDao().getAllWholesalers();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Wholesaler successful created !", ""));
                wholesaler = new Wholesaler();
                user.setUserRoles(UserRoles.WHOLESALER);
                user.setFirstName(firstName);
                user.setEmail(email);
                user.setPassword(password);
                new UserDao().create(user);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cell not selected !", ""));
            }
        } catch (Exception e) {
        }
    }

    public void newRetailer() {
        try {
            retailer.setDateOfBirth(new java.sql.Date(dateOfBirth.getTime()));
            retailer.setUserRoles(UserRoles.RETAILER);
            retailer.setEmail(email);
            retailer.setPassword(password);
            retailer.setFirstName(firstName);
            cell = new CellDao().getOnecell(selectedCell);
            if (cell != null) {
                retailer.setCell(cell);
                new RetailerDao().create(retailer);
                retailers = new RetailerDao().getAllRetailers();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "RETAILER successful created !", ""));
                retailer = new Retailer();
                user.setUserRoles(UserRoles.RETAILER);
                user.setFirstName(firstName);
                user.setEmail(email);
                user.setPassword(password);
                new UserDao().create(user);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cell not selected !", ""));
            }
        } catch (Exception e) {
        }
    }

    public void newAdmin() {
        try {
            administrator.setDateOfBirth(new java.sql.Date(dateOfBirth.getTime()));
            administrator.setUserRoles(UserRoles.ADMIN);
            administrator.setEmail(email);
            administrator.setPassword(password);
            administrator.setFirstName(firstName);
            cell = new CellDao().getOnecell(selectedCell);
            if (cell != null) {
                administrator.setCell(cell);
                new AdministratorDao().create(administrator);
                administrators = new AdministratorDao().getAdministrators();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Administrator successful created !", ""));
                administrator = new Administrator();
                user.setUserRoles(UserRoles.ADMIN);
                user.setFirstName(firstName);
                user.setEmail(email);
                user.setPassword(password);
                new UserDao().create(user);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cell not selected !", ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // END OF USERS RECORDING PROCES

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<      GETTERS AND SETTERS BEGINS HERE        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public String getEntered() {
        return entered;
    }

    public void setEntered(String entered) {
        this.entered = entered;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(int selectedCell) {
        this.selectedCell = selectedCell;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Wholesaler getWholesaler() {
        return wholesaler;
    }

    public void setWholesaler(Wholesaler wholesaler) {
        this.wholesaler = wholesaler;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public int getSelectedProvince() {
        return selectedProvince;
    }

    public void setSelectedProvince(int selectedProvince) {
        this.selectedProvince = selectedProvince;
    }

    public int getSelectedDistrict() {
        return selectedDistrict;
    }

    public void setSelectedDistrict(int selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
    }

    public int getSelectedSector() {
        return selectedSector;
    }

    public void setSelectedSector(int selectedSector) {
        this.selectedSector = selectedSector;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Wholesaler> getWholesalers() {
        return wholesalers;
    }

    public void setWholesalers(List<Wholesaler> wholesalers) {
        this.wholesalers = wholesalers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }
    
}
