package homework.v3;


import homework.v3.entity.serialize.JsonFileClass;

import java.io.IOException;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.classwork.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * Сделать файл с минимум пятью элементами
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * 9) Составленную в п.1 сущность представить в виде xsd-схемы и
 * выполнить генерацию классов аналогично классам из пакета classwork.entity.jaxb
 * * можно сделать и с json-схемой, пренципиально механизм не поменяется.
 * */

public class HomeWork {

    private static String inJsonFilename = "parameters.v1.json";
    private static String serializationBinaryFilename = "homework.parameters.ser";
    private static String externalizableBinaryFilename = "homework.parameters.exter";
    private static String jsonFromSerializedFilename = "homework.result.ser.parameters.json";
    private static String jsonFromExternalizedFilename = "homework.result.exter.parameters.json";
    private static String outJsonFilename = "homework.result.json";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        checkSerialize();
        checkExternalize();
    }

    private static void checkSerialize() throws IOException, ClassNotFoundException {
        JsonFileClass jsonFileClass = JsonSerialization.read(inJsonFilename, JsonFileClass.class);
        JsonSerialization.write(jsonFileClass, outJsonFilename);
        BinarySerialization.writeSerializable(jsonFileClass, serializationBinaryFilename);
        JsonFileClass serializationFileClass = BinarySerialization.readSerializable(serializationBinaryFilename, JsonFileClass.class);
        JsonSerialization.write(serializationFileClass, jsonFromSerializedFilename);
    }

    private static void checkExternalize() throws IOException, ClassNotFoundException {
        homework.v3.entity.externalize.JsonFileClass jsonFileClass = JsonSerialization.read(inJsonFilename,  homework.v3.entity.externalize.JsonFileClass.class);
        BinarySerialization.writeExternalizable(jsonFileClass, externalizableBinaryFilename);
        homework.v3.entity.externalize.JsonFileClass externalizationFileClass = BinarySerialization.readExternalizable(externalizableBinaryFilename, homework.v3.entity.externalize.JsonFileClass.class);
        JsonSerialization.write(externalizationFileClass, jsonFromExternalizedFilename);
    }
}
