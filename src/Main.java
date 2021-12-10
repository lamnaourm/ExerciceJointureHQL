import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.models.Departement;
import com.hibernate.models.Employe;
import com.hibernate.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		
		System.out.println("1- Tous les departement");
		List<Departement> deps = s.createNamedQuery("dept.req1").getResultList();
		for(Departement d: deps)
			System.out.println(d);
		
		System.out.println("2- Tous les employes");
		List<Employe> emps = s.createNamedQuery("emp.req1").getResultList();
		for(Employe d: emps)
			System.out.println(d);
		
		String d = "Loans";
		System.out.println("3- Tous les departement de departement " + d);
		List<Employe> emps1 = s.createNamedQuery("emp.req2")
				.setParameter("name", d)
				.getResultList();
		for(Employe em: emps1)
			System.out.println(em);
		

		System.out.println("4- Nombre employes par departement" + d);
		List<Object[]> emps2 = s.createNamedQuery("emp.req3").getResultList();
		for(Object[] em: emps2)
			System.out.println(em[0] + " - " + em[1]);
		
		System.out.println("4- start_date, first_name employes par departement Administration" + d);
		List<Object[]> emps3 = s.createNamedQuery("emp.req4").getResultList();
		for(Object[] em: emps3)
			System.out.println(em[0] + " - " + em[1]);
		
		System.out.println("4- Supprimer tous les employs");
		System.out.println(s.createNamedQuery("emp.req5").executeUpdate());
		
		System.out.println("5- Inserer une nouvelle deparement");
		Departement ddd = new Departement();
		ddd.setId(1);
		Employe emp = new Employe(); 
		emp.setFirst_name("NewEmp1");
		emp.setLast_name("NewEmp2");
		emp.setTitle("NewEmp3");
		emp.setStart_date(LocalDate.of(2009, 1, 1));
		emp.setDepartement(ddd);
		s.save(emp);
		
		System.out.println("6- Mettre a jour tous les employs");
		System.out.println(s.createNamedQuery("emp.req6").executeUpdate());
		
		
		t.commit();
		s.close();

	}

}
