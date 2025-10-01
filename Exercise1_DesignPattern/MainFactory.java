interface Document {
    void open();
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening a PDF Document..."); }
}

class WordDocument implements Document {
    public void open() { System.out.println("Opening a Word Document..."); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening an Excel Document..."); }
}

// Factory class
class DocumentFactory {
    public static Document createDocument(String type) {
        switch(type.toLowerCase()) {
            case "pdf": return new PdfDocument();
            case "word": return new WordDocument();
            case "excel": return new ExcelDocument();
            default: throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

public class MainFactory {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("pdf");
        doc1.open();

        Document doc2 = DocumentFactory.createDocument("word");
        doc2.open();

        Document doc3 = DocumentFactory.createDocument("excel");
        doc3.open();
    }
}
