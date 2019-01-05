package avramenko.lab01.fillers;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * <h1>Fillers</h1>
 * <p>Fillers is an annotation. It helps (@code Analyzer) to find all fillers.</p>
 * @author Avramenko Kateryna
 * @version 1.3
 * @see Retention
 * @see Target
 * @see ElementType
 * @see RetentionPolicy
 * @see java.lang.annotation.Annotation
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Fillers {
    /**
     * @return a name of annotation
     */
    String name();
}
