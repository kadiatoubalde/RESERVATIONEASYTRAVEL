package org.reservation_backend.fonction;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Fonction {
    public static <T, U> T updateEntityWithNonNullFields(T target, U source, String... ignoreFields) {
        Set<String> ignoreSet = new HashSet<>(Arrays.asList(ignoreFields));

        Field[] fields = source.getClass().getDeclaredFields();
        for (Field sourceField : fields) {
            try {
                sourceField.setAccessible(true);
                String fieldName = sourceField.getName();

                if (ignoreSet.contains(fieldName)) {
                    continue;
                }

                Object value = sourceField.get(source);
                if (value != null) {
                    Field targetField = getField(target.getClass(), fieldName);
                    if (targetField != null) {
                        if (!targetField.canAccess(target)) {
                            targetField.setAccessible(true);
                        }

                        if (targetField.getType().isEnum() && value instanceof String) {
                            Object enumValue = Enum.valueOf((Class<Enum>) targetField.getType(), (String) value);
                            targetField.set(target, enumValue);
                        } else {
                            targetField.set(target, value);
                        }
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new RuntimeException("Failed to update field: " + sourceField.getName(), e);
            }
        }

        return target;
    }

    private static Field getField(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass(); // continue with superclass
            }
        }
        return null;
    }

}
