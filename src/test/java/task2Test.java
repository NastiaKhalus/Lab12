import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.task2.Group;
import ua.edu.ucu.apps.task2.Signature;


import static org.junit.jupiter.api.Assertions.*;

public class task2Test {

    private Group<Integer> group;
    private Signature<Integer> signature;

    @BeforeEach
    public void setUp() {
        group = new Group<>();
        signature = new Signature<>(System.out::println);
    }

    @Test
    public void testTaskFreezeGeneratesId() {
        signature.freeze();
        assertNotNull(signature.getId());
    }

    @Test
    public void testGroupApplySetsHeader() {
        group.addTask(signature);
        group.apply(10);

        assertNotNull(signature.getHeader("groupId"));
        assertEquals(group.groupUuid, signature.getHeader("groupId"));
    }

    @Test
    public void testSignatureApply() {
        StringBuilder result = new StringBuilder();
        Signature<Integer> customSignature = new Signature<>(result::append);
        customSignature.apply(42);

        assertEquals("42", result.toString());
    }

    @Test
    public void testNestedGroupExecution() {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println));
        nestedGroup.addTask(new Signature<>(x -> System.out.println(x * x)));
        
        group.addTask(nestedGroup).addTask(new Signature<>(x -> System.out.println(x * x * x)));
        group.apply(5);
        // Assertions are based on the expected output, which can be verified via logs or mocks.
        assertNotNull(group.groupUuid);
    }

    @Test
    public void testUnmodifiableTasksAfterApply() {
        group.addTask(signature);
        group.apply(10);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            group.addTask(new Signature<>(System.out::println));
        });

        assertNotNull(exception);
    }
}
