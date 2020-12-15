package postgre.luquidbase.boot.service.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.IdentityHashMap;
import java.util.Map;


/**
 * <p>Создаваемый тип, используется в качестве параметра контекста (Context)
 *  * чтобы отслеживать циклы в графах.</p>
 * <p>
 * Зависит от фактически используемого варианта, 2 метода, которые определены ниже,
 * возможно также изменить, только принимая поеределенные типы аргуметов,
 * например, базовые классы узлов графа, избегая необоходимости захвата любых других объектов,
 * которые не обязательлно приведут к результату зацикливания
 */
@Component
public class CycleAvoidingMappingContext {

    private Map<Object, Object> knownInstances = new IdentityHashMap<Object, Object>();

    @BeforeMapping
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {

        T t = (T) knownInstances.get(source);
        return t;
    }

    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put( source, target );
    }
}
