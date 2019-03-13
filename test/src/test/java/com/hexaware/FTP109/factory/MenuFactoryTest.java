package com.hexaware.FTP109.factory;
import org.junit.Test;
import mockit.Mocked;
import mockit.Mock;
import mockit.MockUp;
import mockit.Expectations;
import mockit.Verifications;
import static org.junit.Assert.assertEquals;
import com.hexaware.FTP109.persistence.MenuDAO;
import com.hexaware.FTP109.model.MenuDetails;
import java.util.List;
import java.util.ArrayList;


/**
 *Testing the menufactory.
 */
public class MenuFactoryTest {
  /**
  * Testing the vendor and food id.
  * @param dao gives the Mocked MenuDAO.
  */
  @Test
  public final void testFindByVenFoodId(@Mocked final MenuDAO  dao) {
    new Expectations() { {
        dao.countVenFoodId(5, 6); result = 6;
      } };
    new MockUp<MenuFactory>() {
        @Mock
        public MenuDAO dao() {
            return dao;
        }
    };
    int count = MenuFactory.findByVenFoodId(5, 6);
    assertEquals(6, count);

    new Verifications() { {
        dao.countVenFoodId(5, 6); times = 1;
      } };
  }
    /**
  * Testing the food id.
  * @param dao gives the dao connection.
  */
  @Test
  public final void findByFoodId(@Mocked final MenuDAO  dao) {
    new Expectations() { {
        dao.countFoodId(70); result = 70;
      } };
    new MockUp<MenuFactory>() {
        @Mock
        public MenuDAO dao() {
            return dao;
        }
    };
    int count = MenuFactory.findByFoodId(70);
    assertEquals(70, count);

    new Verifications() { {
        dao.countFoodId(70); times = 1;
      } };
  }
    /**
  * Testing the food id.
  * @param dao gives the dao connection.
  */
  @Test
  public final void testGetMenuDetails(@Mocked final MenuDAO  dao) {
    final MenuDetails m1 = new MenuDetails(1, "Paneer Momos", 100, 11, "Maruthi", 5);
    final MenuDetails m2 = new MenuDetails(2, "BBQ", 200, 12, "Guru", 4);
    final List<MenuDetails> menuDetails = new ArrayList();
    new Expectations() { {
        menuDetails.add(m1);
        menuDetails.add(m2);
        dao.getMenuDetails(); result = menuDetails;
      } };
    new MockUp<MenuFactory>() {
        @Mock
        public MenuDAO dao() {
            return dao;
        }
    };
    final MenuFactory mu = new MenuFactory();
    List<MenuDetails> menu = MenuFactory.getMenuDetails();
    assertEquals(menu.size(), 2);
    assertEquals(menu.size(), 2);
    assertEquals(menu.size(), menuDetails.size());

    new Verifications() { {
        dao.getMenuDetails(); times = 1;
      } };
  }

}
