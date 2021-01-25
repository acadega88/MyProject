package lib.utils;

import java.io.File;
import java.util.Objects;

public class FileDownload {

    /**
     * Is file download
     *
     * @param downloadPath downloadPath
     * @param fileName fileName
     * @return boolean
     */
    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        assert dir_contents != null;
        for (File dir_content : dir_contents) {
            if (dir_content.getName().equals(fileName))
                return true;
        }
        return false;
    }

    /**
     * Is file with specific extension download
     *
     * @param dirPath dirPath
     * @param ext ext
     * @return boolean
     */
    public static boolean isFileDownloaded_Ext(String dirPath, String ext) {
        boolean flag = false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        for (int i = 1; i < Objects.requireNonNull(files).length; i++) {
            if (files[i].getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Get latest download file
     *
     * @param dirPath dirPath
     * @return Latest download file
     */
    public static File getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }
}