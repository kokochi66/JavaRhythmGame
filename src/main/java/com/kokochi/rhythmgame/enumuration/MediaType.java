package com.kokochi.rhythmgame.enumuration;

public enum MediaType {
    IMAGE, VIDEO, UNKNOWN;


    public static MediaType determineMediaType(String filePath) {
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();

        switch (extension) {
            case "png":
            case "jpg":
            case "jpeg":
            case "gif":
                return MediaType.IMAGE;
            case "mp4":
            case "mkv":
            case "avi":
            case "flv":
                return MediaType.VIDEO;
            default:
                return MediaType.UNKNOWN;
        }
    }
}

