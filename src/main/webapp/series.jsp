<%@ include file="header.jsp" %>
<h1>Series Calculation</h1>

<form action="series" method="post" class="form-group">
  <label for="x">x (must be in (-1, 1)):</label>
  <input type="number" step="0.01" class="form-control" id="x" name="x"
         value="${param.x != null ? param.x : '0.5'}" required>

  <label for="n">Number of terms (n):</label>
  <input type="number" class="form-control" id="n" name="n"
         value="${param.n != null ? param.n : '5'}" required>

  <label for="e1">Error threshold e1:</label>
  <input type="number" step="0.0001" class="form-control" id="e1" name="e1"
         value="${param.e1 != null ? param.e1 : '0.01'}" required>

  <label for="e2">Error threshold e2:</label>
  <input type="number" step="0.0001" class="form-control" id="e2" name="e2"
         value="${param.e2 != null ? param.e2 : '0.001'}" required>

  <button type="submit" class="btn btn-primary mt-2">Calculate</button>
</form>
