package StudentsAndUniversity.repositories;

import StudentsAndUniversity.models.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
public class StudentRepository implements UserRepository<Student> {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public void create(Student student) {
        student.setId(getMaxId() + 1);
        students.add(student);
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public int remove(String fullName) {
        int removeCount = 0;

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getFullName().equals(fullName)) {
                iterator.remove();
                removeCount++;
            }
        }
        return removeCount;
    }

    @Override
    public List<Student> getAllByGroupTitle(String groupTitle) {
        return students.stream()
                .filter(student -> student.getGroupTitle().equals(groupTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllByGroupTitleandID(String groupTitle, Long id) {
        return getAll()
                .stream()
                .filter(user -> user.getGroupTitle().equals(groupTitle) && user.getId().equals(id))
                .collect(Collectors.toList());
    }

    private Long getMaxId() {
        Long maxId = 0L;
        for (Student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;
    }
}
