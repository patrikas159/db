import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainTest {
    Student local;
    StudentDAO studentDAO;
    @Mock
    StudentDAOI studentDAOI;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Before
    public void setup(){
        studentDAO = new StudentDAO(studentDAOI);
         local = new Student("Antanelis11", "IT 18/1 T", 2.5, "KTU", 1, "2021-04-23");
    }
    @Test
    public void searchByIdTest(){
        Student mocked = new Student("Antanelis11", "IT 18/1 T", 2.5, "KTU", 1, "2021-04-23");
        when(studentDAOI.searchById(1)).thenReturn(mocked);
        assertEquals(local,studentDAO.searchById(1));
        verify(studentDAOI).searchById(1);
    }
    private void assertEquals(Student local, Student mocked){
        Assert.assertEquals(local.getVardas(),mocked.getVardas());
        Assert.assertEquals(local.getId(),mocked.getId());
    }
}
