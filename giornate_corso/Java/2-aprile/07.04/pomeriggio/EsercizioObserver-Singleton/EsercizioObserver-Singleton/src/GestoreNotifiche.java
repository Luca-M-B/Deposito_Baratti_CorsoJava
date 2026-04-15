// Interfaccia Subject
public interface GestoreNotifiche {

    void aggiungiOsservatore(Notificatore notificatore);

    void rimuoviOsservatore(Notificatore notificatore);

    void notifica();
}