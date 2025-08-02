// ग्राहक जोडा
document.getElementById("addCustomerForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("name").value;
    const mobile = document.getElementById("mobile").value;

    fetch("http://localhost:8080/api/customers", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, mobile })
    })
    .then(res => res.json())
    .then(data => {
        alert("ग्राहक जतन झाला!");
        this.reset();
    })
    .catch(error => {
        alert("त्रुटी: ग्राहक जतन करताना अडचण आली");
        console.error(error);
    });
});

// उधारी नोंदवा
document.getElementById("addUdhariForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("udhariName").value;
    const itemName = document.getElementById("itemName").value;
    const amount = document.getElementById("amount").value;

    fetch(`http://localhost:8080/api/udhari?name=${name}&itemName=${itemName}&amount=${amount}`, {
        method: "POST"
    })
    .then(res => res.json())
    .then(data => {
        alert("उधारी जतन झाली!");
        this.reset();
    })
    .catch(error => {
        alert("त्रुटी: उधारी जतन होत नाही");
        console.error(error);
    });
});

// फेड नोंदवा
document.getElementById("repaymentForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("repaymentName").value;
    const amount = document.getElementById("repaymentAmount").value;

    fetch(`http://localhost:8080/api/repayments?name=${name}&amount=${amount}`, {
        method: "POST"
    })
    .then(res => res.json())
    .then(data => {
        alert("फेड जतन झाली!");
        this.reset();
    })
    .catch(error => {
        alert("त्रुटी: फेड जतन करताना अडचण");
        console.error(error);
    });
});

// शिल्लक पहा
document.getElementById("checkBalanceForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("balanceName").value;

    fetch(`http://localhost:8080/api/summary/${name}`)
    .then(res => {
        if (!res.ok) throw new Error("ग्राहक सापडला नाही");
        return res.json();
    })
    .then(data => {
        document.getElementById("balanceResult").innerHTML = `
            <h3>📋 ग्राहक माहिती</h3>
            <p>👤 नाव: ${data.name}</p>
            <p>📱 मोबाईल: ${data.mobile}</p>
            <p>🧾 एकूण उधारी: ₹${data.totalUdhari}</p>
            <p>💰 एकूण फेड: ₹${data.totalRepayment}</p>
            <p><strong>🔔 उरलेली रक्कम: ₹${data.remainingBalance}</strong></p>
        `;
    })
    .catch(error => {
        alert("त्रुटी: " + error.message);
        document.getElementById("balanceResult").innerHTML = "";
    });
});

// उधारी ग्राहकांची यादी
function loadUdhariCustomers() {
    fetch("http://localhost:8080/api/customers/udhari-customers")
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("udhariCustomerList");
            list.innerHTML = ""; // Clear previous list

            if (data.length === 0) {
                list.innerHTML = "<li>💡 सध्या कोणतीही उधारी नाही.</li>";
                return;
            }

            data.forEach(customer => {
                const li = document.createElement("li");
                li.textContent = `👤 नाव: ${customer.name} | 📱 मोबाइल: ${customer.mobile}`;
                list.appendChild(li);
            });
        })
        .catch(error => {
            console.error("उधारी ग्राहक यादी आणताना त्रुटी:", error);
            alert("❌ त्रुटी: यादी आणता आली नाही.");
        });
}
