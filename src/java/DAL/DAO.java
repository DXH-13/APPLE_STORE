package DAL;

import Models.Accounts;
import Models.Cart;
import Models.Categories;
import Models.Color;
import Models.Customers;
import Models.Item;
import Models.Order;
import Models.ProductOptions;
import Models.Products;
import Models.Reviews;
import Models.Storage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAO extends DBContext {

    private Connection con;
    private String status;
    private List<ProductOptions> prodop;
    private HashMap<Integer, Color> color;
    private HashMap<Integer, Storage> storage;
    public HashMap<Integer, Products> prod;
    private HashMap<Integer, Categories> cate;

    PreparedStatement ps = null;
    ResultSet rs = null;

    public DAO() {
        prodop = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductOptions> getProdop() {
        return prodop;
    }

    public void setProdop(List<ProductOptions> prodop) {
        this.prodop = prodop;
    }

    public HashMap<Integer, Color> getColor() {
        return color;
    }

    public void setColor(HashMap<Integer, Color> color) {
        this.color = color;
    }

    public HashMap<Integer, Storage> getStorage() {
        return storage;
    }

    public void setStorage(HashMap<Integer, Storage> storage) {
        this.storage = storage;
    }

    public HashMap<Integer, Products> getProd() {
        return prod;
    }

    public void setProd(HashMap<Integer, Products> prod) {
        this.prod = prod;
    }

    public HashMap<Integer, Categories> getCate() {
        return cate;
    }

    public void setCate(HashMap<Integer, Categories> cate) {
        this.cate = cate;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void loadDB() {
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,\"\n"
                + "                + \" po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,\"\n"
                + "                + \" cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID";
        prodop = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
            }

        } catch (Exception e) {
            status = "Erorr get ProductOptions table: " + e.getMessage();

        }

        color = new HashMap<Integer, Color>();
        sql = "select * from Color_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                color.put(rs.getInt("ColorID"), new Color(rs.getInt("ColorID"), rs.getString("ColorName")));
            }

        } catch (Exception e) {
            status = "Erorr get Color table: " + e.getMessage();
        }

        storage = new HashMap<Integer, Storage>();
        sql = "select * from Storage_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storage.put(rs.getInt("StorageID"), new Storage(rs.getInt("StorageID"), rs.getString("Storage")));
            }
        } catch (Exception e) {
            status = "Erorr get Storage table: " + e.getMessage();
        }

        cate = new HashMap<Integer, Categories>();
        sql = "select * from Categories_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cate.put(rs.getInt("CategoryID"), new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName")));
            }

        } catch (SQLException e) {
            status = "Erorr get Products table: " + e.getMessage();
        }

        prod = new HashMap<Integer, Products>();
        sql = "select * from Products_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod.put(rs.getInt("ProductID"), new Products(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"), rs.getString("Description")));
            }

        } catch (Exception e) {
            status = "Erorr get Products table: " + e.getMessage();
        }

    }
//================================= Login & SignUp =================================//

    public Accounts UpdateProfile(String username, String firstName, String lastName, String email, String phone, String birthDay, boolean gender, String address) {
        String query = "UPDATE [dbo].[Accounts_HE172161]\n"
                + "   SET \n"
                + "      FirstName = ?,\n"
                + "      LastName = ?,\n"
                + "      Email = ?,\n"
                + "      Phone = ?,\n"
                + "      Birthday = ?,\n"
                + "      Gender = ?,\n"
                + "      Address = ?\n"
                + " WHERE Username = ?\n";
        try {
            ps = con.prepareStatement(query);
            ps.setString(8, username);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, birthDay);
            ps.setBoolean(6, gender);
            ps.setString(7, address);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at Update: " + e.getMessage();
        }
        return null;
    }

    public Accounts UpdateMoney(String username, double money) {
        String query = "UPDATE [dbo].[Accounts_HE172161] SET Money = ? WHERE Username = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(2, username);
            ps.setDouble(1, money);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at Update: " + e.getMessage();
        }
        return null;
    }

    public Accounts ForgetPass(String password, String email) {
        String query = "UPDATE Accounts_HE172161 SET Password = ? WHERE Email = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at Update: " + e.getMessage();
        }
        return null;
    }

    public Accounts UpdatePassword(String username, String password) {
        String query = "UPDATE [dbo].[Accounts_HE172161] SET Password = ? WHERE Username = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(2, username);
            ps.setString(1, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at Update: " + e.getMessage();
        }
        return null;
    }

    public Accounts checkLogin(String user, String pass) {
        String query = "SELECT * FROM Accounts_HE172161 WHERE Username = ? AND Password = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                Accounts a = new Accounts(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getDouble(13));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Accounts checkUsername(String user) {
        String query = "SELECT * FROM Accounts_HE172161 WHERE Username = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                Accounts a = new Accounts(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getDouble(13));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Accounts checkEmail(String email) {
        String query = "SELECT * FROM Accounts_HE172161 WHERE Email = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Accounts a = new Accounts(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getDouble(13));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Accounts checkSignUp(String user, String pass, String email) {
        String query = "INSERT INTO Accounts_HE172161 (Username,Password,Email,isAdmin)\n"
                + "VALUES \n"
                + "(?,?,?,0) ";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
            while (rs.next()) {
                return new Accounts(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getDouble(13));
            }
        } catch (Exception e) {
        }
        return null;
    }

//================================= ProductOption & Cart =================================//
    public List<Reviews> getReviews() {
        List<Reviews> list = new ArrayList<>();
        String sql = "SELECT r.ReviewID, r.AccountID, r.ReviewDate, r.Comment, a.AccountID, a.Username, a.Password, a.isAdmin, a.FirstName, a.LastName, a.Email, a.Phone, a.Birthday, a.Gender, a.Region, a.Address, a.Money\n"
                + "FROM Reviews_HE172161 AS r\n"
                + "LEFT JOIN Accounts_HE172161 AS a ON r.AccountID = a.AccountID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reviews r = new Reviews();
                r.setReviewID(rs.getInt("ReviewID"));
                r.setAccountID(rs.getInt("AccountID"));
                r.setReviewDate(rs.getString("ReviewDate"));
                r.setComment(rs.getString("Comment"));

                Accounts a = new Accounts(rs.getInt("AccountID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("isAdmin"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getDate("Birthday"),
                        rs.getBoolean("Gender"),
                        rs.getString("Region"),
                        rs.getString("Address"),
                        rs.getDouble("Money"));
                r.setA(a);
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Order> getOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT o.OrderID, o.AccountID, o.OrderDate, o.TotalPrice, a.AccountID, a.Username, a.Password, a.isAdmin, a.FirstName, a.LastName, a.Email, a.Phone, a.Birthday, a.Gender, a.Region, a.Address, a.Money\n"
                + "FROM Orders_HE172161 AS o\n"
                + "LEFT JOIN Accounts_HE172161 AS a ON o.AccountID = a.AccountID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("OrderID"));
                o.setAccountID(rs.getInt("AccountID"));
                o.setOrderDate(rs.getString("OrderDate"));
                o.setTotalPrice(rs.getInt("TotalPrice"));

                Accounts acc = new Accounts(rs.getInt("AccountID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("isAdmin"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getDate("Birthday"),
                        rs.getBoolean("Gender"),
                        rs.getString("Region"),
                        rs.getString("Address"),
                        rs.getDouble("Money"));
                o.setAcc(acc);
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Order getOrderCheck() {
        String sql = "SELECT TOP 1 o.OrderID, o.AccountID, o.OrderDate, o.TotalPrice, a.AccountID, a.Username, a.Password, a.isAdmin, a.FirstName, a.LastName, a.Email, a.Phone, a.Birthday, a.Gender, a.Region, a.Address, a.Money\n"
                + "                FROM Orders_HE172161 AS o\n"
                + "                LEFT JOIN Accounts_HE172161 AS a ON o.AccountID = a.AccountID\n"
                + "                ORDER BY o.OrderID DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("OrderID"));
                o.setAccountID(rs.getInt("AccountID"));
                o.setOrderDate(rs.getString("OrderDate"));
                o.setTotalPrice(rs.getInt("TotalPrice"));

                Accounts acc = new Accounts(rs.getInt("AccountID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("isAdmin"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getDate("Birthday"),
                        rs.getBoolean("Gender"),
                        rs.getString("Region"),
                        rs.getString("Address"),
                        rs.getDouble("Money"));
                o.setAcc(acc);
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductOptions> getAll() {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<ProductOptions> getAllByProduct(int id) {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID "
                + "Where po.ProductID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductOptions> getAllByStorage(int id) {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID "
                + "Where po.StorageID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductOptions> searchByName(String txtSearch) {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID "
                + "Where p.ProductName like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductOptions getProductOptionsByID(int id) {
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,\n"
                + "       po.ProductID AS pID, p.CategoryID, p.ProductName, p.Description, po.ColorID AS clID,\n"
                + "       cl.ColorName, po.StorageID AS sID, s.Storage\n"
                + "FROM ProductOptions_HE172161 po\n"
                + "LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID\n"
                + "LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID\n"
                + "LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID\n"
                + "WHERE po.ProductOptionID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                return po;

            }
        } catch (Exception ex) {
        }
        return null;
    }

    public List<Categories> getAllCategories() {
        List<Categories> list = new ArrayList<>();
        String sql = "select * from Categories_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Categories(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Products> getAllProducts() {
        List<Products> list = new ArrayList<>();
        String sql = "select * from Products_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Color> getAllColor() {
        List<Color> list = new ArrayList<>();
        String sql = "select * from Color_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Color(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Storage> getAllStorage() {
        List<Storage> list = new ArrayList<>();
        String sql = "select * from Storage_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Storage(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

//================================= Insert & Update =================================//
    public void Insert(int productOptionID, int productID, int colorID, int storageTypeID, double price, int promotionID, String photo1, String photo2) {
        String sql = "Insert into ProductOptions_HE172161 values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productOptionID);
            ps.setInt(2, productID);
            ps.setInt(3, colorID);
            ps.setInt(4, storageTypeID);
            ps.setDouble(5, price);
            ps.setInt(6, promotionID);
            ps.setString(7, photo1);
            ps.setString(8, photo2);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Erorr at Insert: " + e.getMessage();
        }
    }

    public void Update(int productOptionID, int productID, int colorID, int storageTypeID, double price, int promotionID, String photo1, String photo2) {
        String sql = "Update ProductOptions_HE172161 set ProductID=?, ColorID=?, StorageID=?, Price =?, PromotionID=?, Photo1=?, Photo2=? where ProductOptionID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productID);
            ps.setInt(2, colorID);
            ps.setInt(3, storageTypeID);
            ps.setDouble(4, price);
            ps.setInt(5, promotionID);
            ps.setString(6, photo1);
            ps.setString(7, photo2);
            ps.setInt(8, productOptionID);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at Update: " + e.getMessage();
        }
    }

    public void Delete(String pid) {
        String sql = "delete from ProductOptions_HE172161 where productOptionID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Delete: " + e.getMessage();
        }
    }

    public int countProduct() {
        String query = "select count(*) from ProductOptions_HE172161";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void addOrder(Accounts a, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        String sql = "INSERT INTO Orders_HE172161\n"
                + "           (AccountID\n"
                + "           ,OrderDate\n"
                + "           ,TotalPrice)\n"
                + "     VALUES\n"
                + "           (?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getAccountID());
            ps.setString(2, date);
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();

            String sql1 = "SELECT TOP 1 OrderID FROM Orders_HE172161 ORDER BY OrderID DESC";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt("OrderID");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into OrderItems_HE172161 VALUES (?,?,?,?)";
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, i.getProductOption().getProductOptionID());
                    ps2.setInt(3, i.getQuantity());
                    ps2.setDouble(4, i.getPrice());
                    ps2.executeUpdate();
                }
            }
        } catch (SQLException ex) {
        }
    }

//    public void addOrderDetail(Cart cart) {
//        String sql = " Select top 1 OrderID from [Order] order by OrderID desc";
//        PreparedStatement pre;
//        try {
//            pre = conn.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            while ((rs.next())) {
//                int oid = rs.getInt(1);
//                for (Item i : cart.getItems()) {
//                    String sql1 = "INSERT INTO [dbo].[OrderDetail]\n"
//                            + "           ([OrderID]\n"
//                            + "           ,[ProductID]\n"
//                            + "           ,[Quantity]\n"
//                            + "           ,[Price])\n"
//                            + "     VALUES\n"
//                            + "           (?,?,?,?) ";
//                    PreparedStatement pre2 = conn.prepareStatement(sql1);
//                    pre2.setInt(1, oid);
//                    pre2.setInt(2, i.getProduct().getId());
//                    pre2.setInt(3, i.getQuantity());
//                    pre2.setDouble(4, i.getPrice());
//                    pre2.executeUpdate();
//                }
//            }
//        } catch (SQLException ex) {
//        }
//
//    }
    public List<ProductOptions> offsetCount(int index) {
        List<ProductOptions> list = new ArrayList<>();
        String query = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,\n"
                + "                po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,\n"
                + "                cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID\n"
                + "                order by po.ProductOptionID\n"
                + "				OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 12);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Customers> insertCustomer(int accountID, String firstName, String lastName, String email, String phone, String birthDay, boolean gender, String region, String address) {
        List<Customers> list = new ArrayList<>();
        String query = "INSERT INTO [dbo].[Customers_HE172161]\n"
                + "           ([AccountID]\n"
                + "           ,[FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Email]\n"
                + "           ,[Phone]\n"
                + "           ,[Birthday]\n"
                + "           ,[Gender]\n"
                + "           ,[Region]\n"
                + "           ,[Address])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, birthDay);
            ps.setBoolean(7, gender);
            ps.setString(8, region);
            ps.setString(9, address);
            ps.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    public List<ProductOptions> getAllByCategories(int id) {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,\n"
                + "                po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,\n"
                + "                cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID\n"
                + "				WHERE p.ProductID IN (\n"
                + "    SELECT ProductID\n"
                + "    FROM Products_HE172161\n"
                + "    WHERE CategoryID = ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductOptions> getAllByColor(int id) {
        List<ProductOptions> list = new ArrayList<>();
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID "
                + "Where po.ColorID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                list.add(po);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductOptions selectDetail(int model, int color, int storage) {
        String sql = "SELECT po.ProductOptionID, po.Price, po.PromotionID, po.Photo1, po.Photo2,"
                + " po.ProductID pID, p.CategoryID, p.ProductName, p.Description, po.ColorID clID,"
                + " cl.ColorName, po.StorageID sID, s.Storage FROM ProductOptions_HE172161 po LEFT JOIN Products_HE172161 p ON p.ProductID = po.ProductID LEFT JOIN Storage_HE172161 s ON s.StorageID = po.StorageID LEFT JOIN Color_HE172161 cl ON cl.ColorID = po.ColorID "
                + "WHERE po.ProductID = ? AND po.ColorID = ? AND po.StorageID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, model);
            ps.setInt(2, color);
            ps.setInt(3, storage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductOptions po = new ProductOptions();
                po.setProductOptionID(rs.getInt("ProductOptionID"));
                po.setPrice(rs.getDouble("Price"));
                po.setPromotionID(rs.getInt("PromotionID"));
                po.setPhoto1(rs.getString("Photo1"));
                po.setPhoto2(rs.getString("Photo2"));
                Products p = new Products(rs.getInt("pID"), rs.getInt("categoryID"), rs.getString("ProductName"), rs.getString("Description"));
                po.setP(p);
                Color cl = new Color(rs.getInt("clID"), rs.getString("ColorName"));
                po.setCl(cl);
                Storage s = new Storage(rs.getInt("sID"), rs.getString("Storage"));
                po.setS(s);
                return po;
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public int getAccountId() {
        int accountId = 0;
        String query = "SELECT TOP 1 [AccountID] FROM Accounts_HE172161 ORDER BY [AccountID] DESC";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                accountId = rs.getInt("AccountID");
            }
        } catch (Exception e) {
        }
        return accountId;
    }

    public List<Reviews> selectReviews() {
        List<Reviews> list = new ArrayList<>();
        String sql = "select * from Reviews_HE172161";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Reviews(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertReviews(String accountID, String comment) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        String sql = "INSERT INTO Reviews_HE172161 VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountID);
            ps.setString(2, date);
            ps.setString(3, comment);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at Insert" + e.getMessage();
        }
    }

    public void updateUserMoney(Accounts account) {
        try {
            String sql = "UPDATE Accounts_HE172161 SET Money = ? WHERE AccountID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, account.getMoney());
            ps.setInt(2, account.getAccountID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stonk(double money) {
        String sql = "update Accounts_HE172161 set Money = Money + ? \n"
                + "where isAdmin = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, money);
            int rowsUpdated = ps.executeUpdate();
            System.out.println(rowsUpdated + " rows updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countOrdersForAccounts() {
        String sql = "SELECT COUNT(o.OrderID) AS SoLuongDonHang "
                + "FROM Orders_HE172161 AS o "
                + "LEFT JOIN Accounts_HE172161 AS a ON o.AccountID = a.AccountID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SoLuongDonHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public double getMoneyForAdminAccounts() {
        String sql = "SELECT Money FROM Accounts_HE172161 WHERE isAdmin = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("Money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1.0;
    }

    public Accounts getTopAccountWithHighestMoney() {
        String sql = "SELECT TOP 1 FirstName, LastName, Money "
                + "FROM Accounts_HE172161 "
                + "ORDER BY Money DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                double money = rs.getDouble("Money");
                return new Accounts(firstName, lastName, money);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //    public Order getTopAccountWithMostOrders() {
//        String sql = "SELECT TOP 1 a.Username, COUNT(o.OrderID) AS SoLuongDonHang "
//                + "FROM Orders_HE172161 AS o "
//                + "LEFT JOIN Accounts_HE172161 AS a ON o.AccountID = a.AccountID "
//                + "GROUP BY a.Username "
//                + "ORDER BY COUNT(o.OrderID) DESC";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                String username = rs.getString("Username");
//                int soLuongDonHang = rs.getInt("SoLuongDonHang");
//                return new Order(username, soLuongDonHang);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        DAO d = new DAO();
//
//        int soLuongDonHang = d.countOrdersForAccounts();
//        System.out.println("Số lượng đơn hàng cho tài khoản: " + soLuongDonHang);
//
////        Order topAccount = d.getTopAccountWithMostOrders();
////        if (topAccount != null) {
////            System.out.println("Tài khoản có nhiều đơn hàng nhất: " + topAccount.getUsername());
////        } else {
////            System.out.println("Không có tài khoản nào có đơn hàng.");
////        }
//        double moneyForAdmin = d.getMoneyForAdminAccounts();
//        if (moneyForAdmin >= 0) {
//            System.out.println("Số tiền của tài khoản có isAdmin = 1: " + moneyForAdmin);
//        } else {
//            System.out.println("Không tìm thấy tài khoản có isAdmin = 1 hoặc lỗi trong quá trình truy vấn.");
//        }
//        
//        Accounts a = d.getTopAccountWithHighestMoney();
//        System.out.println(a);
//    }
    
}

