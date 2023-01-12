import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        VStack {
            Text("Mercado Libre")
                .font(.system(size: 40, weight: .bold, design: .rounded))
                .padding(.bottom, 40)
            SearchbarView(action: {text in
                self.viewModel.getProducts(productName: text)
            }).padding(.top, -30)
            List {
                ForEach(self.viewModel.products, id: \.self) { item in
                    Text(item.name ?? "")
                }
            }
        }
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var products: [Results] = []
        let service = SearchProductsApi()
        init() {}
        func getProducts(productName: String) {
            service.search(query: productName) { productsSearch, error in
                DispatchQueue.main.async {
                    if let meliProducts = productsSearch?.results {
                        self.products = meliProducts
                    } else {
                        print(error?.localizedDescription ?? "error")
                    }
                }
            }
        }
    }


}
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel())
            .previewDevice(PreviewDevice(rawValue: "iPhone 14"))
            .previewDisplayName("iPhone 14")
    }
}
