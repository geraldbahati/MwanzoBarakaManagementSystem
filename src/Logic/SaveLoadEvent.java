package Logic;

import Data.Models.Member;

import java.io.*;

public class SaveLoadEvent {


    public void saveMember(Member member) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("MemberInfo.bin");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(member);

            fileOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Member loadSavedMember() {
        Member member = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("MemberInfo.bin");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            System.out.println("here");
            member = (Member) inputStream.readObject();
            System.out.println(member.getMemberID());
            fileInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return member;
        }
        return member;
    }

    public boolean deleteSavedFile() {
        File file = new File("MemberInfo.bin");
        return file.delete();
    }
}
