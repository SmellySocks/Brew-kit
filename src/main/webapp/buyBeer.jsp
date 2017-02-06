<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page import="domain.model.Beer" %>
<%@ page import="domain.model.Brewery" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form enctype="text/plain">

Pozycja:<br />
    <textarea name="beerName"/>tyskie</textarea><br /><br/>
    	Browar:<br />
                <select name="brewery">
                        <%
                        try {
                        	List<Brewery> breweries = Arrays.asList(Brewery.values());
                           for(Brewery Brewery:breweries){
                        %><option value="<%=Brewery%>"><%=Brewery%></option>
                        <%
                           }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                        </select> <br/>


		<input type = "submit" formaction="DbServlet" value = "zakup!" /> <br />
        </form>              
</body>
</html>