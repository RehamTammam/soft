<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<form action="/social/FriendPostconn" method="post">
  NameOfOwner : <input type="text" name="Owner" /> <br>
  NameOfFriend : <input type="text" name="Friend" /> <br>
 whatYouWantToSay : <input type="text" name="Content" /> <br>
 FeelingWith : <input type="text" name="Feeling" /> <br>
Privacy : <input type="text" name="Privacy" /> <br>
  <input type="submit" value="postFriend">
</body>
</html>