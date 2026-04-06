import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AttendanceSystemTest {

    @Test
    public void testPercentageCalculation() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("John", 45, 60);
        // Expected: (45/60) * 100 = 75.0%
        assertEquals(75.0, student.calculatePercentage(), 0.001);
    }

    @Test
    public void testEligibleStatus() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("Alice", 80, 100);
        double percentage = student.calculatePercentage();

        assertTrue(percentage >= 75.0, "Student should be eligible for exams");
    }

    @Test
    public void testWarningStatus() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("Bob", 70, 100);
        double percentage = student.calculatePercentage();

        // 70% is < 75% but > 65%
        assertTrue(percentage < 75.0 && percentage >= 65.0, "Student should be in warning zone");
    }

    @Test
    public void testCriticalStatus() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("Charlie", 10, 100);
        double percentage = student.calculatePercentage();

        assertTrue(percentage < 65.0, "Student should be in critical status");
    }

    @Test
    public void testZeroTotalClasses() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("NoClass", 0, 0);
        assertEquals(0.0, student.calculatePercentage(), "Should handle zero classes without crashing");
    }

    @Test
    public void testPerfectAttendance() {
        AttendanceSystem.Student student = new AttendanceSystem.Student("Perfect", 50, 50);
        assertEquals(100.0, student.calculatePercentage());
    }
}