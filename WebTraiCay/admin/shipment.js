'use strict';
let arrow = document.querySelectorAll(".arrow");
let closeSideBarBtn = document.querySelector(".btn-close-home");

for (var i = 0; i < arrow.length; i++) {
  arrow[i].addEventListener("click", (e) => {
    let arrowParent = e.target.parentElement.parentElement; // Trở về phần tử cha của mũi tên
    arrowParent.classList.toggle("showMenu");
  });
}

let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");

sidebarBtn.addEventListener("click", () => {
  sidebar.classList.toggle("close");

  // Sau khi toggle sidebar, kiểm tra và điều chỉnh hiển thị nút đóng sidebar
  if (!sidebar.classList.contains("close")) {
    closeSideBarBtn.style.display = "inline-block"; // Hiển thị nút đóng
  } else {
    closeSideBarBtn.style.display = "none"; // Ẩn nút đóng
  }
});

closeSideBarBtn.addEventListener("click", () => {
  sidebar.classList.toggle("close");
  closeSideBarBtn.style.display = "none"; // Luôn ẩn nút đóng khi click để đóng sidebar
});

var myVar;

function myFunction() {
  myVar = setTimeout(showPage, 800);
}

function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("myDiv").style.display = "block";
}

$('.tab').on('click', function () {
  $('.tab').removeClass('active');
  $(this).addClass('active');

});

var data = [
  {
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Hết hàng',
    imageUrl: 'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/294491648_571890434421859_2466714619768542754_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeF7h6pIxPQiw4ZFJNFufBaPo14pXz6aCZGjXilfPpoJkSKmtr6q0N95d2Mk_orTFoSe6O0g4-hYqfzQ-o8YzoRC&_nc_ohc=TuE_z7sumOkQ7kNvgGeP2DP&_nc_ht=scontent.fsgn2-8.fna&oh=00_AYCNjXSL2KJtk_7lL2vQJ23NIC051rupGl4MTOQUdFBqYA&oe=668CECDD',
    productCode: 'A002',
    stockQuantity: '120 ',
    supplier: 'Công Ty TNHH ABC',
    monthlySales: '30 sản phẩm',
    productName: 'Cam',
    expiryDate: '15 - 12 - 2024',
    lastUpdate: '05 - 04 - 2024',
    monthlyRevenue: '1.500.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Còn hàng',
    imageUrl: 'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/294491648_571890434421859_2466714619768542754_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeF7h6pIxPQiw4ZFJNFufBaPo14pXz6aCZGjXilfPpoJkSKmtr6q0N95d2Mk_orTFoSe6O0g4-hYqfzQ-o8YzoRC&_nc_ohc=TuE_z7sumOkQ7kNvgGeP2DP&_nc_ht=scontent.fsgn2-8.fna&oh=00_AYCNjXSL2KJtk_7lL2vQJ23NIC051rupGl4MTOQUdFBqYA&oe=668CECDD',
    productCode: 'A002',
    stockQuantity: '120 ',
    supplier: 'Công Ty TNHH ABC',
    monthlySales: '30 sản phẩm',
    productName: 'Cam',
    expiryDate: '15 - 12 - 2024',
    lastUpdate: '05 - 04 - 2024',
    monthlyRevenue: '1.500.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/294491648_571890434421859_2466714619768542754_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeF7h6pIxPQiw4ZFJNFufBaPo14pXz6aCZGjXilfPpoJkSKmtr6q0N95d2Mk_orTFoSe6O0g4-hYqfzQ-o8YzoRC&_nc_ohc=TuE_z7sumOkQ7kNvgGeP2DP&_nc_ht=scontent.fsgn2-8.fna&oh=00_AYCNjXSL2KJtk_7lL2vQJ23NIC051rupGl4MTOQUdFBqYA&oe=668CECDD',
    productCode: 'A002',
    stockQuantity: '120 ',
    supplier: 'Công Ty TNHH ABC',
    monthlySales: '30 sản phẩm',
    productName: 'Cam',
    expiryDate: '15 - 12 - 2024',
    lastUpdate: '05 - 04 - 2024',
    monthlyRevenue: '1.500.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Còn hàng',
    imageUrl: 'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/294491648_571890434421859_2466714619768542754_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeF7h6pIxPQiw4ZFJNFufBaPo14pXz6aCZGjXilfPpoJkSKmtr6q0N95d2Mk_orTFoSe6O0g4-hYqfzQ-o8YzoRC&_nc_ohc=TuE_z7sumOkQ7kNvgGeP2DP&_nc_ht=scontent.fsgn2-8.fna&oh=00_AYCNjXSL2KJtk_7lL2vQJ23NIC051rupGl4MTOQUdFBqYA&oe=668CECDD',
    productCode: 'A002',
    stockQuantity: '120 ',
    supplier: 'Công Ty TNHH ABC',
    monthlySales: '30 sản phẩm',
    productName: 'Cam',
    expiryDate: '15 - 12 - 2024',
    lastUpdate: '05 - 04 - 2024',
    monthlyRevenue: '1.500.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Hết hàng',
    imageUrl: 'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/294491648_571890434421859_2466714619768542754_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeF7h6pIxPQiw4ZFJNFufBaPo14pXz6aCZGjXilfPpoJkSKmtr6q0N95d2Mk_orTFoSe6O0g4-hYqfzQ-o8YzoRC&_nc_ohc=TuE_z7sumOkQ7kNvgGeP2DP&_nc_ht=scontent.fsgn2-8.fna&oh=00_AYCNjXSL2KJtk_7lL2vQJ23NIC051rupGl4MTOQUdFBqYA&oe=668CECDD',
    productCode: 'A002',
    stockQuantity: '120 ',
    supplier: 'Công Ty TNHH ABC',
    monthlySales: '30 sản phẩm',
    productName: 'Cam',
    expiryDate: '15 - 12 - 2024',
    lastUpdate: '05 - 04 - 2024',
    monthlyRevenue: '1.500.000 vnd'
  },
  {
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  },{
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  },{
    batchCode: '001',
    status: 'Sắp hết hạn',
    imageUrl: 'https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/309007133_628584232085812_416912229949138941_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeHlqmYdhbA38kSphv3DFzrcgFxm5iJU6dOAXGbmIlTp02GGdwbtdHVKbD6q7hKgW2KweD8KOfhPboGSq24Twaeg&_nc_ohc=Btp-GpCRWHsQ7kNvgH4AD0u&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYDTVXVE-WNVkOghDcqwceyvfcm2NrA7iVmzKNGluEVVsQ&oe=668CF243',
    productCode: 'A001',
    stockQuantity: '61 ',
    supplier: 'Công Ty TNHH Seon Gold HCM',
    monthlySales: '61 sản phẩm',
    productName: 'Dưa hấu',
    expiryDate: '30 - 04 - 2024',
    lastUpdate: '25 - 04 - 2024',
    monthlyRevenue: '2.730.000 vnd'
  }
];

function renderTableBody(data) {
  var tbody = $('#table-body');
  data.forEach(function(item) {
    var statusElement = applyStatusColor(item.status);
    var cardHtml = `
                <tr>
                    <td>
                        <div class="card">
                            <div class="card-header">
                                <span class="batch-code">Mã lô hàng: ${item.batchCode}</span>
                                 ${statusElement.outerHTML}
                            </div>
                            <div class="card-body">
                                <div class="product-image">
                                    <img src="${item.imageUrl}" alt="Product Image">
                                </div>
                                <div class="product-details">
                                    <div class="product-code">
                                        <label>Mã sản phẩm</label>
                                        <span>${item.productCode}</span>
                                    </div>
                                    <div class="stock-quantity">
                                        <label>Số lượng có sẵn trong kho</label>
                                        <span>${item.stockQuantity}</span>
                                    </div>
                                    <div class="product-supplier">
                                        <label>Bên cung cấp sản phẩm</label>
                                        <span>${item.supplier}</span>
                                    </div>
                                    <div class="monthly-sales">
                                        <label>Số bán trong tháng</label>
                                        <span>${item.monthlySales}</span>
                                    </div>
                                    <div class="product-name">
                                        <label>Tên sản phẩm</label>
                                        <span>${item.productName}</span>
                                    </div>
                                    <div class="expiry-date">
                                        <label>Ngày hết hạn</label>
                                        <span>${item.expiryDate}</span>
                                    </div>
                                    <div class="last-update">
                                        <label>Ngày biến động gần nhất</label>
                                        <span>${item.lastUpdate}</span>
                                    </div>
                                    <div class="monthly-revenue">
                                        <label>Doanh thu tháng này</label>
                                        <span>${item.monthlyRevenue}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>`;
    tbody.append(cardHtml);
  });
}

renderTableBody(data);
function applyStatusColor(status) {
  var statusElement = document.createElement('span');
  statusElement.textContent = status;
  statusElement.classList.add('status');

  if (status === 'Còn hàng') {
    statusElement.classList.add('status-green');
  } else if (status === 'Gần hết hàng') {
    statusElement.classList.add('status-yellow');
  } else { // 'Hết hàng', 'Hết hạn sử dụng'
    statusElement.classList.add('status-red');
  }

  return statusElement;
}

new DataTable("#inventory-table", {
  searching: false,
  bDeferRender: true,
  searchDelay: 500,
  scrollY: '600px',
  scrollCollapse: true,
  columnDefs: [
    { targets: '_all', className: 'dt-body-left' }
  ]
})


// table for date
let table = new DataTable("#inventory-history-table", {
  searching: false,
  bDeferRender: true,
  searchDelay: 500,
  columnDefs: [
    { targets: '_all', className: 'dt-body-left' }
  ],
  createdRow: function(row, data, dataIndex) {
    // Add color class based on positive or negative change
    let change = data[1];
    if (change.includes('+')) {
      $(row).find('td:eq(1)').addClass('positive');
    } else if (change.includes('-')) {
      $(row).find('td:eq(1)').addClass('negative');
    }
  }
});

function renderTable(date) {
  // Clear existing data
  table.clear();

  // Fetch data based on the selected date
  let data = getDataByDate(date);

  // Add new data
  table.rows.add(data);
  table.draw();
}

function getDataByDate(date) {
  // Dummy data - Replace with your actual data fetching logic
  const data = {
    '04/2024': [
      ["xxxxx", "+ 79", "Thêm hàng", "22 - 04 - 2024", "ĐM LĂNG CỌC"],
      ["xxxxx", "- 33", "Bán cho khách", "20 - 04 - 2024", ""]
    ],
    '03/2024': [
      // Add data for 03/2024
    ],
    '02/2024': [
      // Add data for 02/2024
    ],
    '01/2024': [
      // Add data for 01/2024
    ],
    '12/2023': [
      // Add data for 12/2023
    ]
  };
  return data[date] || [];
}

$('.tab-date').on('click', function() {
  $('.tab-date').removeClass('active');
  $(this).addClass('active');
  let date = $(this).data('date');
  renderTable(date);
});

// Default render for the first tab
renderTable('04/2024');
$('button[data-date="04/2024"]').addClass('active');

