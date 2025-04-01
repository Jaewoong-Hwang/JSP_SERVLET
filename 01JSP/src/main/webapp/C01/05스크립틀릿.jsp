<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
     <%
    	java.util.Scanner sc = new java.util.Scanner(System.in);
   		System.out.println("단 입력:");
   		int dan = sc.nextInt();
   		int mul = 0;
   		for(int i=1; i<=dan; i++){
   			
   			mul = i*dan;
   			
   			System.out.printf("%d x %d = %d\n", dan,i,mul);
   		}
   		
    %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  
단수 입력받아 해당 구구단을 찍어보세요(Table로 만드세요 - 스크립틀릿)
-->

<table>
		<tbody>
			<%
				//tr태그 생성 반복
				for(int i=0;i<dan;i++)
				{
				%>
					<tr>
						<%
						for(int j=0;j<col;j++){
						%>
							
								<td><%=i+":"+j %><td/>
								
							
						<% 
							
						}
						
						%>
						
					<tr/>
					<% 
				}
			
			%>
		
		
		</tbody>
	
	
	
	</table>


</body>
</html>