import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("M-TP", "Son Tung MTP");
        album.addSong("Con Mua Ngang Qua", 4.48);
        album.addSong("Anh Sai Roi", 4.12);
        album.addSong("Nang Am Xa Dan", 3.08);
        album.addSong("Em Cua Ngay hom qua", 4.23);
        album.addSong("Chac Ai Do Se Ve", 4.22);
        album.addSong("Khong Phai Dang Vua Dau", 4.07);
        album.addSong("Thai Binh Mo Hoi Roi", 6.02);
        album.addSong("Khuon Mat Dang Thuong", 4.17);
        album.addSong("Tien Len Viet Nam Oi", 3.38);
        album.addSong("An Nut Nho...Tha Giac Mo", 4.04);
        album.addSong("Am Tham Ben Em", 4.53);
        album.addSong("Buong Doi Tay Nhau Ra", 3.47);
        album.addSong("Mot Nam Moi Binh An", 4.08);
        albums.add(album);

        album = new Album("Illusion of the heart", "seycara");
        album.addSong("I wish you would come closer and hold me", 4.03);
        album.addSong("counting stars", 4.07);
        album.addSong("Chromatic Dellusion", 4.09);
        album.addSong("night market", 3.15);
        album.addSong("luv u", 5.18);
        album.addSong("illusion of the heart", 5.21);
        album.addSong("Easily", 3.51);
        album.addSong("Will I ever see you again", 1.09);
        album.addSong("epilouge", 4.00);
        album.addSong("emplace", 2.37);
        albums.add(album);

        List<Song> playList = new Vector<Song>();
        albums.get(0).addToPlayList("Anh Sai Roi", playList);
        albums.get(0).addToPlayList("An Nut Nho...Tha Giac Mo", playList);
        albums.get(0).addToPlayList("Am Tham Ben Em", playList);
        albums.get(0).addToPlayList("Mot Nam Moi Binh An", playList);
        albums.get(0).addToPlayList("Tien Len Viet Nam Oi", playList);

        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(10, playList);

        play(playList);



    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }





















}
