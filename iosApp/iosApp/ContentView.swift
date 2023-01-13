import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        VStack {
            ZStack {
                Color("main")
                    .edgesIgnoringSafeArea(.top)
                VStack {
                    Text("Mercado Libre")
                        .font(.system(size: 40, weight: .bold, design: .rounded))
                        .padding(.bottom, 40)
                    SearchbarView(action: {text in
                        self.viewModel.getProducts(productName: text)
                    }).padding(.top, -30)
                }
            }.frame(height: 150)
            List {
                ForEach(self.viewModel.products, id: \.self) { item in
                    HStack {
                        if #available(iOS 15.0, *) {
                            AsyncImage(url: URL(string: item.pictures[0].url ?? ""), content: { image in
                                image.resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(maxWidth: 300, maxHeight: 100)
                            },
                            placeholder: {
                                ProgressView()
                            })
                        }
                        Text(item.name ?? "")
                            .fontWeight(.bold)
                    }
                    Spacer()
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
            service.search(query: productName) { productsSearched, error in
                DispatchQueue.main.async {
                    if let products = productsSearched?.results {
                        self.products = products
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
