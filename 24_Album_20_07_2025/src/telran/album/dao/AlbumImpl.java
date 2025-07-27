package telran.album.dao;

import telran.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Predicate;

public class AlbumImpl implements Album {

    private Photo[] photos;
    private int size = 0;

    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if(photos.length == size || photo == null || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(photos, 0, size, photo);
        if(index < 0) index = -index -1;
        System.arraycopy(photos,index,photos,index+1,size - index);
        photos[index] = photo;
        size++;
        return true;

    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        Photo pattern = new Photo(albumId, photoId, null, null, null);
        for (int i = 0; i < size; i++) {
            if(photos[i].equals(pattern)) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        if(getPhotoFromAlbum(albumId,photoId) != null ) {
            getPhotoFromAlbum(albumId,photoId).setUrl(url);
            return true;
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        Photo pattern = new Photo(albumId, photoId, null, null, null);
        for (int i = 0; i < size; i++) {
            if(photos[i].equals(pattern)) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return getPhotoByPredicate(photo -> photo.getAlbumId() == albumId);
    }

    public Photo[] getPhotoBetweenDate2(LocalDate dateFrom, LocalDate dateTo) {
        return getPhotoByPredicate(photo -> {
            LocalDate photoDate = photo.getDate().toLocalDate();
            return !photoDate.isBefore(dateFrom) && !photoDate.isAfter(dateTo);
                }
                );

//        return getPhotoByPredicate(photo -> (photo.getDate().compareTo(dateFrom.atStartOfDay()) >= 0 &&
//                                                    photo.getDate().compareTo(dateTo.atStartOfDay().plusDays(1)) < 0));
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {

        Photo pattern = new Photo(0,0, null, null, dateFrom.atStartOfDay() );

        int from = Arrays.binarySearch(photos, 0, size, pattern);
        while(from >= 0) {
            from = Arrays.binarySearch(photos, 0, from,  pattern);
        }
        from = -from -1;

        pattern = new Photo(0,0, null, null, LocalDateTime.of(dateTo, LocalTime.MAX));

        int to = Arrays.binarySearch(photos, 0, size, pattern);
        while(to >= 0) {
            to = Arrays.binarySearch(photos, to + 1, size,  pattern);
        }
        to = -to -1;

        return Arrays.copyOfRange(photos, from, to);
    }

    @Override
    public int size() {
        return size;
    }

    private Photo[] getPhotoByPredicate(Predicate<Photo> predicate) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            if(predicate.test(photos[i])) {
                count++;
            }
        }

        Photo[] res = new Photo[count];

        for (int i = 0; i < size; i++) {
            if(predicate.test(photos[i]) ) {
                res[j++] = photos[i];
            }
        }
        return res;
    }
}
