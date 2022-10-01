package Logic;

import Data.Models.Member;

public class MemberEvent {
    public static void submitMemberToDatabase(Member member){
        final String sqlStatement = member.toSqlStatement();

    }
}
