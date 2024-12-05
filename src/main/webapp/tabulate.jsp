<%@ include file="header.jsp" %>
<h1>Function Tabulation</h1>
<form action="tabulate" method="post" class="form-group">
  <label for="a">Start (a):</label>
  <input type="number" step="0.1" class="form-control" id="a" name="a" required>
  <label for="b">End (b):</label>
  <input type="number" step="0.1" class="form-control" id="b" name="b" required>
  <label for="h">Step (h):</label>
  <input type="number" step="0.1" class="form-control" id="h" name="h" required>
  <button type="submit" class="btn btn-primary mt-2">Tabulate</button>
</form>
