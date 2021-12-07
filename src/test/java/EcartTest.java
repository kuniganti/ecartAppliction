import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ecart.order.entity.Address;
import com.ecart.order.entity.Author;
import com.ecart.order.entity.BankAccount;
import com.ecart.order.entity.BillingDetails;
import com.ecart.order.entity.Book;
import com.ecart.order.entity.Category;
import com.ecart.order.entity.Contact;
import com.ecart.order.entity.CreditCard;
import com.ecart.order.entity.Image;
import com.ecart.order.entity.Item;
import com.ecart.order.entity.Locality;
import com.ecart.order.entity.LoginEntity;
import com.ecart.order.entity.User;
import com.ecart.persistence.PersistenceEntityManager;

public class EcartTest {

	public static void main(String[] args) {
		try{		
			EcartTest etest = new EcartTest();
		//etest.testBillingDetailsInheritance();
		//etest.testEmbededAddress();
		//etest.testSet();
			//etest.testSetwithObjectHolding();
			//etest.testManyToOneAssociation();
			//etest.getCategoriesAndDeleteone();
			//etest.getCategoriesAndDeleteonewithONDELETE();
			//etest.createAddressesFortheUser();
			//etest.getProxyForCategory();
			//etest.createQueryForCategory();
			//etest.createManyToManyRelationShip();
			//etest.createCriteriaBuilderQuery();
			//etest.createCriteriaBuilderQueryWithWhereClause();
			etest.createUser();
			
		System.exit(0);
		}catch(Exception e){
			e.printStackTrace();
		System.exit(0);
		}
	}

	private void createUser() {
		User usr = new User();
		usr.setName("Chandra");
		usr.setGender('M');
		usr.setContact(new ArrayList<Contact>());
		Address adr = new Address();
		adr.setUser(usr);
		usr.setShippingaddress(adr);
		LoginEntity login = new LoginEntity(0, "ckuniganti", "prime", 0, new Date());
		//usr.setLoginEntity(login);
		login.setUser(usr);
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(usr);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	private void createCriteriaBuilderQueryWithWhereClause() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery authorCriteriaQuery = cb.createQuery(Author.class);
		Root<Author> a = authorCriteriaQuery.from(Author.class);
		authorCriteriaQuery.select(a).where(cb.equal(a.get("authorID"), 1L));
		Query q = em.createQuery(authorCriteriaQuery);
		Author auths = (Author) q.getSingleResult();
		System.out.println(auths);
	}
	
	/*private void createCriteriaBuilderQueryWithWhereClause() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery authorCriteriaQuery = cb.createQuery(Author.class);
		Root<Author> a = authorCriteriaQuery.from(Author.class);
		authorCriteriaQuery.select(a).where(cb.equal(a.get("authorID"), 1L));
		Query q = em.createQuery(authorCriteriaQuery);
		Author auths = (Author) q.getSingleResult();
		System.out.println(auths);
	}*/

	private void createCriteriaBuilderQuery() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery authorCriteriaQuery = cb.createQuery();
		authorCriteriaQuery.select(authorCriteriaQuery.from(Author.class)) ;
		Query q = em.createQuery(authorCriteriaQuery);
		List<Author> auths = q.getResultList();
		
		System.out.println(auths);
	}
	
	private void createManyToManyRelationShip() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		Set<Author> auths = new HashSet<>();
		Author a1 = new Author(0, "Chandra");
		Author a2 = new Author(0, "balu");
		
		
		Set<Book> books = new HashSet<>();
		Book b1 = new Book(0, "IRYKF3453", new Date());
		b1.setAuthors(auths);
		Book b2 = new Book(0, "342234KF3453", new Date());
		b2.setAuthors(auths);
		books.add(b1);
		books.add(b2);
		a1.setBooks(books);
		a2.setBooks(books);
		auths.add(a1);
		auths.add(a2);
		
		em.persist(a1);
		em.persist(a2);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	private void createQueryForCategory() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select c from Category c where c.categoryID=:id");
		q.setParameter("id", 2L);
		System.out.println(q.getSingleResult());
		
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	private void getProxyForCategory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eCartPersistance");
			EntityManager em = PersistenceEntityManager.getEntityManager();
			em.getTransaction().begin();
			
			Category c1 = em.getReference(Category.class, 2L);
			System.out.println(factory.getPersistenceUnitUtil().isLoaded(c1));
			Category c = em.find(Category.class, 2L);
			
			System.out.println(factory.getPersistenceUnitUtil().isLoaded(c));
			System.out.println(factory.getPersistenceUnitUtil().isLoaded(c1));
			/*Hibernate.initialize(c);
			//System.out.println(c.getName());
			System.out.println(Persistence.createEntityManagerFactory("eCartPersistance").getPersistenceUnitUtil().isLoaded(c));*/
			em.flush();
			em.getTransaction().commit();
			em.close();
		
	}

	private void createAddressesFortheUser() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		Contact c1 = new Contact("chanduece420@gmail.com", "9441476331");
		Contact c2 = new Contact("ckuniganti@primetgi.com", "989898989");
		List<Contact> concts = new ArrayList<>();
		concts.add(c1);
		concts.add(c2);
		
		
		User usr = new User( 0,"Chandra Sekhar kuniganti",concts);
		
		
		Locality l1 =new Locality("hyd", 500081, "ind");
		Address Shipping = new Address(0, "Ganesh charmy's nilayam", "Vital Rao Nager",usr, l1);
		
		Locality l2 =new Locality("hyd", 500081, "ind");
		Address billing = new Address(0, "Krish sapphire ", "madhapur",usr, l2);
		
		usr.setShippingaddress(Shipping);
		//usr.setBillingAddress(billing);
		em.persist(usr);
		
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	private void getCategoriesAndDeleteonewithONDELETE() {
		
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		Category c = em.find(Category.class, 1L);
		System.out.println("Category Electronics"+c);
		em.remove(c);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	private void getCategoriesAndDeleteone() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		em.getTransaction().begin();
		Category c = em.find(Category.class, 1L);
		System.out.println("Category Electronics"+c);
		//em.remove(c);
		
		for(Item item :c.getItems()){
			//item.setCategory(null);
			em.remove(item);
		}
		c.getItems().clear();
		/*Category c1 = em.find(Category.class, 1L);
		System.out.println("Category Electronics"+c1);*/
		//em.persist(c);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	private void testManyToOneAssociation() {
		EntityManager em = PersistenceEntityManager.getEntityManager();
		/*System.out.println(item);*/
		em.getTransaction().begin();
		Set<String> imagePaths1 = new HashSet<>();
		imagePaths1.add("aasfa/asdasd/asdasd11.jpeg");
		imagePaths1.add("aasfa/asdasd/asdasd12.jpeg");
		Set<String> imagePaths2 = new HashSet<>();
		imagePaths2.add("aasfa/asdasd/asdasd21.jpeg");
		imagePaths2.add("aasfa/asdasd/asdasd22.jpeg");
		
		Category category1 = new Category(0, "Electronics");
		Category category2 = new Category(0, "Books");
		
		em.persist(category1);
		em.persist(category2);
		
		Item item1 = new Item(0, "dell inspiron 7559 BLK",category1,  500000, "amazon", imagePaths1);
		category1.getItems().add(item1);
		//em.persist(item1);
		
		Item item2 = new Item(0, "Nokia lumia",category1, 250000, "amazon", imagePaths2);
		category1.getItems().add(item2);
		//em.persist(item2);
		
		Item item3 = new Item(0, "Effec JAVA",category2, 500, "amazon", null);
		category2.getItems().add(item3);
		//em.persist(item3);
		
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	private void testSetwithObjectHolding() {
		Image img1 = new Image("sdfsfdsdfsdfsdfsdfsdf1", ( short)1221, ( short)1551);
		Image img2 = new Image("sdfsfdsdfsdfsdfsdfsdf2", ( short)1222, ( short)1552);
		Image img3 = new Image("sdfsfdsdfsdfsdfsdfsdf3", ( short)1223, ( short)1553);
		Image img4 = new Image("sdfsfdsdfsdfsdfsdfsdf4", ( short)1224, ( short)1554);
		Set<Image> imgs = new HashSet<>();
		imgs.add(img1);imgs.add(img2);imgs.add(img3);imgs.add(img4);
		//Item item = new Item(0, "love for dummies", "book", 589, "love", imgs);
		EntityManager em = PersistenceEntityManager.getEntityManager();
		/*System.out.println(item);
		em.getTransaction().begin();
		em.persist(item);*/
		//System.out.println(em.find(Item.class, 8L));
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	private void testSet() {
		/*Set<String> imgs = new HashSet<>();*/
		List<String> imgs = new ArrayList<>();
		imgs.add("root:/home");
		imgs.add("d:/home/img1");
		imgs.add("c:home/img1");
		/*Item item = new Item(0, "hibernate 2", "Books", 555, "pearson", imgs);
		EntityManager em = PersistenceEntityManager.getEntityManager();
		System.out.println(item);
		em.getTransaction().begin();
		em.persist(item);
		//System.out.println(em.find(Item.class, 8L));
		
		em.flush();
		em.getTransaction().commit();
		em.close();*/
		
	}

	private void testEmbededAddress() {
		Locality l = new Locality("Hyderabad", 5000081, "India");
		Address add = new Address(0, "Ganesh charmy's Nilayam", "vital rao nagar", null, l);
		EntityManager em = PersistenceEntityManager.getEntityManager();
		System.out.println(add);
		em.getTransaction().begin();
		//em.persist(add);
		
		System.out.println(em.find(Address.class, 1L));
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	private void testBillingDetailsInheritance() {
		BillingDetails b = null;
		 b = new BankAccount(50100021767614L, "banjaraHills", "HDFC000521");
		 b = new CreditCard(0, 5326760121625896L, new Date(), "Chandra");
		b.setTransactionDate(new Date());
		EntityManager em = PersistenceEntityManager.getEntityManager();
		System.out.println(b);
		em.getTransaction().begin();
		em.persist(b);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

}
