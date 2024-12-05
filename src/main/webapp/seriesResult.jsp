<%@ include file="header.jsp" %>
<h1>Series Calculation Results</h1>

<c:if test="${not empty x}">
    <p><strong>x:</strong> ${x}</p>
    <p><strong>n:</strong> ${n}</p>

    <h3>Results:</h3>
    <ul>
        <li>Exact value: <strong>${exact}</strong></li>
        <li>Sum of n terms: <strong>${sumN}</strong></li>
        <li>Sum of terms > e1: <strong>${sumAboveE1}</strong> (Count: <strong>${termCountE1}</strong>)</li>
        <li>Sum of terms > e2: <strong>${sumAboveE2}</strong> (Count: <strong>${termCountE2}</strong>)</li>
    </ul>
</c:if>

<a href="series.jsp" class="btn btn-secondary">Back</a>
