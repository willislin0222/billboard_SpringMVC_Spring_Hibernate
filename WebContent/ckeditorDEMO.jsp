<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CkeditorDEMO</title>
</head>
<body>
	<textarea name="editor1" id="editor1" rows="10" cols="80">
         This is my textarea to be replaced with CKEditor.
    </textarea>
    <script type="text/javascript">
        CKEDITOR.replace( 'editor1' );
    </script>
</body>
</html>