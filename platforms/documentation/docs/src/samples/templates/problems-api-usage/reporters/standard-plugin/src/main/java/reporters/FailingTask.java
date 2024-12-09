package reporters;

import org.gradle.api.DefaultTask;
import org.gradle.api.problems.Problems;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;

public abstract class FailingTask extends DefaultTask {

    @Inject
    public abstract Problems getProblems();

    @TaskAction
    public void run() {
        // tag::problems-api-fail-the-build[]
        throw getProblems().getReporter().throwing(problemSpec -> {
            problemSpec.id("sample-error", "Sample Error");
            problemSpec.contextualLabel("This happened because ProblemReporter.throwing() was called");
            problemSpec.details("This is a demonstration of how to add\ndetailed information to a build failure");
            problemSpec.documentedAt("https://example.com/docs");
            problemSpec.withException(new RuntimeException("Message from runtime exception"));
            problemSpec.solution("Remove the Problems.throwing() method call from the task action");
        });
        // end::problems-api-fail-the-build[]
    }
}