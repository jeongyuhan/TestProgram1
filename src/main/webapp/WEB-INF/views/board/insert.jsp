<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function fn_insert(f) {
			f.action = 'insert.do';
			f.submit();
		}
	</script>
</head>
<body>

	<form method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="bWriter" autofocus /></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="50" name="bContent"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="등록" onclick="fn_insert(this.form)" />
						<input type="button" value="목록" onclick="location.href='selectBoardList.do'"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>